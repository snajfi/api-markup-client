package cz.api.markup.client.services;


import cz.api.markup.client.annotations.Endpoint;
import cz.api.markup.client.configuration.ConfigReader;
import cz.api.markup.client.exceptions.CanNotGetClassesException;
import cz.api.markup.client.exceptions.NoClassesFoundInGivenPackageException;
import cz.api.markup.client.pojos.api.ApiPojo;
import cz.api.markup.client.pojos.api.EndpointPojo;
import cz.api.markup.client.utils.EndpointAnnotations;
import cz.api.markup.client.utils.ErrorCode;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 *  Service which load and hold {@link ApiPojo}.
 *
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@ApplicationScoped
public class ApiService {

    @Inject private UtilsService utils;
    @Inject private ClassesOperationService classesOperation;

    private ApiPojo apiPojo;


    public ApiPojo getApiPojo() throws NoClassesFoundInGivenPackageException, CanNotGetClassesException {
        if (apiPojo==null) {
            apiPojo = new ApiPojo();
            scanApi();
        }
        return apiPojo;
    }

    /**
     * Method is triggered after construction of this singleton object on start up of application.
     *
     * @throws CanNotGetClassesException
     * @throws NoClassesFoundInGivenPackageException
     */
    private void scanApi() throws CanNotGetClassesException, NoClassesFoundInGivenPackageException {

      String packageWithApi = ConfigReader.INSTANCE.configuration().getApiPackage();
      List<String> httpMethods = ConfigReader.INSTANCE.configuration().getHttpMethods();
      List<Class<? extends Annotation>> annotations = EndpointAnnotations.getAnnotationsForMethods(httpMethods);

      if (utils.isNotEmpty(packageWithApi) ) {

          List<Class> classes = classesOperation.getClasses(packageWithApi);
          if (!classes.isEmpty()) {
            List<Method> endpointMethods = classesOperation.getMethodsWithAnnotation(classes,annotations);
            createApiPojoForEndpoints(endpointMethods);
          } else {
              throw new NoClassesFoundInGivenPackageException(ErrorCode.NO_CLASSES_IN_PACKAGE);
          }
      }

    }


    private void createApiPojoForEndpoints(List<Method> endpoints) {

        for (Method endpointMethod: endpoints) {
            Class<? extends Annotation> httpMethodClass = classesOperation.getEndpointAnnotationClassOnMethod(endpointMethod);
            EndpointPojo endpointPojo;
            if(httpMethodClass != null) {
                endpointPojo = new EndpointPojo();
                endpointPojo.setHttpMethod(utils.simpleClassName(httpMethodClass));
                endpointPojo.setMethodName(endpointMethod.getName());

                if (endpointMethod.isAnnotationPresent(Endpoint.class)) {
                    endpointPojo.setDescription(endpointMethod.getAnnotation(Endpoint.class).description());
                }

                Class endpointClass = endpointMethod.getDeclaringClass();
                if (endpointClass.isAnnotationPresent(Path.class)) {
                    endpointPojo.setPath(utils.extractValue(endpointClass.getAnnotation(Path.class),"value"));
                }

                if(endpointMethod.isAnnotationPresent(Produces.class)) {
                    endpointPojo.setProduceType(endpointMethod.getAnnotation(Produces.class).value());
                }

                //TODO: Scan of endpoint parameters implementation missing.

                apiPojo.addEndpoint(endpointPojo);
            }

        }

    }

}
