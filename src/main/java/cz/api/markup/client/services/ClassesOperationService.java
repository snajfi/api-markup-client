package cz.api.markup.client.services;

import cz.api.markup.client.exceptions.CanNotGetClassesException;
import cz.api.markup.client.utils.EndpointAnnotations;
import cz.api.markup.client.utils.ErrorCode;

import javax.ejb.Stateless;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *  This class provide methods connected with search in code for classes, methods and annotations.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@Stateless
public class ClassesOperationService {


    public List<Method> getMethodsWithAnnotation(List<Class> classes, List<Class<? extends Annotation>> annotations) {

        List<Method> methods = new ArrayList<>();

        if (!annotations.isEmpty()) {
            for (Class clazz : classes) {
                methods.addAll(extractMethodsContainsOneOfAnnotations(clazz.getMethods(),annotations));
            }
        }

        return methods;
    }

    /**
     * Scans all classes accessible from the context class loader which belong
     * to the given package and subpackages.
     *
     * @param packageName
     *            The base package
     * @return List of classes founded in requested location.
     * @throws CanNotGetClassesException
     *                    in case of problem with {@link URI} creation, work with {@link ClassLoader}.
     */
    public List<Class> getClasses(String packageName) throws CanNotGetClassesException {
        List<Class> classes = new ArrayList<>();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = null;

            resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<>();

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                URI uri = new URI(resource.toString());

                if (uri.getPath()!=null) {
                    dirs.add(new File(uri.getPath()));
                }
            }

            for (File directory : dirs) {
                classes.addAll(findClasses(directory, packageName));
            }

        } catch (IOException | ClassNotFoundException | URISyntaxException e) {
            throw new CanNotGetClassesException(ErrorCode.CAN_NOT_SCAN_PACKAGE,e);
        }

        return classes;
    }

    private List<Method> extractMethodsContainsOneOfAnnotations(Method[] methods, List<Class<? extends Annotation>> classes) {

        List<Method> extractedMethods = new ArrayList<>();

        for (Method method: methods) {
            for (Class<? extends Annotation> clazz: classes) {
                if (method.isAnnotationPresent(clazz)) {
                    extractedMethods.add(method);
                    break;
                }
            }
        }

        return extractedMethods;
    }

    /**
     * Recursive method used to find all classes in a given directory and
     * subdirs.
     *
     * @param directory
     *            The base directory
     * @param packageName
     *            The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();

        if (files!=null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                }
                else if (file.getName().endsWith(".class")) {
                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                }
            }
        }
        return classes;
    }

    /**
     * Scan all annotations on given method and check if some of them
     * is from {@link EndpointAnnotations}.
     *
     * @param method which should be scanned.
     * @return endpoint annotation or null, when no endpoint annotation was found
     */
    public Class<? extends Annotation> getEndpointAnnotationClassOnMethod(Method method) {
        for (Class<? extends Annotation> clazz: EndpointAnnotations.getAllAnnotationClasses()) {
            if (method.isAnnotationPresent(clazz)){
                return clazz;
            }
        }
        return null;
    }

}
