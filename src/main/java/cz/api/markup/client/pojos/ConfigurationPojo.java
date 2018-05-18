package cz.api.markup.client.pojos;

import java.util.List;

/**
 * Created by snajfi1 on 18.05.2018.
 */
public class ConfigurationPojo {

    private List<String> httpMethods;
    private String apiPackage;

    public List<String> getHttpMethods() {
        return httpMethods;
    }

    public void setHttpMethods(List<String> httpMethods) {
        this.httpMethods = httpMethods;
    }

    public String getApiPackage() {
        return apiPackage;
    }

    public void setApiPackage(String apiPackage) {
        this.apiPackage = apiPackage;
    }
}
