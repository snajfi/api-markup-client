package cz.api.markup.client.tests.unit.services;

import cz.api.markup.client.exceptions.CanNotGetClassesException;
import cz.api.markup.client.services.ClassesOperationService;
import cz.api.markup.client.tests.data.TestClass;
import org.junit.Test;

import javax.ws.rs.GET;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *  Tests for {@link ClassesOperationService} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ClassesOperationServiceTest {

    private ClassesOperationService classesOperation = new ClassesOperationService();

    private Class testClass = TestClass.class;

    @Test
    public void getClassesTestOfValidCall() {
        try {

            List<Class> classes = new ArrayList<>(classesOperation.getClasses(testClass.getPackage().getName()));
            assertTrue(classes.size()==1);

            classes.clear();
            classes.addAll(classesOperation.getClasses("somethingWhatDoNotExist"));
            assertTrue(classes.isEmpty());

        } catch (CanNotGetClassesException e) {
            fail();
        }
    }



    @Test
    public void extractMethodsContainsOneOfAnnotationsTest() {

        List<Class> testClasses = Collections.singletonList(testClass);

        assertTrue(!classesOperation.getMethodsWithAnnotation(testClasses, Collections.singletonList(GET.class)).isEmpty());

    }

    @Test
    public void getEndpointAnnotationClassOnMethodTest() {

        Class get = GET.class;

        List<Class> testClasses = Collections.singletonList(testClass);
        Method method = classesOperation.getMethodsWithAnnotation(testClasses,Collections.singletonList(GET.class)).get(0);

        assertEquals(get,classesOperation.getEndpointAnnotationClassOnMethod(method));


    }

}
