package cz.api.markup.client.services;

import javax.ejb.Stateless;
import java.lang.annotation.Annotation;

/**
 *  This class provide utility methods for easier checking of various conditions.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@Stateless
public class UtilsService {

    public Boolean isEmpty(String string) {
        return string==null || string.isEmpty();
    }

    public Boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public String simpleClassName(Class clazz) {
        String[] packageName = clazz.getName().split("\\.");
        return packageName[packageName.length - 1];
    }

    public String extractValue(Annotation annotation, String attribute) {
        if (annotation!=null) {
            String stringRepresentation = annotation.toString();
            if (stringRepresentation.contains(attribute)) {
                return stringRepresentation.substring(stringRepresentation.indexOf('=',
                        stringRepresentation.indexOf(attribute))+1,stringRepresentation.indexOf(')'));
            }
        }
        return "";
    }

}
