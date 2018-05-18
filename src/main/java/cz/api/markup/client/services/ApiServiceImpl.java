package cz.api.markup.client.services;


import cz.api.markup.client.configuration.ConfigReader;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by snajfi1 on 18.05.2018.
 */
@Singleton
@Startup
public class ApiServiceImpl {


    @PostConstruct
    private void scanApi() {

      String packageWithApi = ConfigReader.INSTANCE.configuration().getApiPackage();



    }



}
