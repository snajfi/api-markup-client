package cz.api.markup.client.services;


import cz.api.markup.client.configuration.ConfigReader;
import cz.api.markup.client.exceptions.CanNotGetClassesException;
import cz.api.markup.client.exceptions.NoClassesFoundInGivenPackageException;
import cz.api.markup.client.pojos.api.ApiPojo;
import cz.api.markup.client.utils.EndpointAnnotations;
import cz.api.markup.client.utils.ErrorCode;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 *  TODO: Write documentation.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@Singleton
@Startup
public class ApiService {

    @Inject private CheckUtilsService checker;
    @Inject private ClassesOperationService classesOperation;

    private ApiPojo apiPojo = new ApiPojo();

    /**
     * Method is triggered after construction of this singleton object on start up of application.
     *
     *
     * @throws CanNotGetClassesException
     * @throws NoClassesFoundInGivenPackageException
     */
    @PostConstruct
    private void scanApi() throws CanNotGetClassesException, NoClassesFoundInGivenPackageException {

      String packageWithApi = ConfigReader.INSTANCE.configuration().getApiPackage();
      List<String> httpMethods = ConfigReader.INSTANCE.configuration().getHttpMethods();
      List<Class<? extends Annotation>> annotations = EndpointAnnotations.getAnnotationsForMethods(httpMethods);

      if (checker.isNotEmpty(packageWithApi) ) {

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



    }

}
