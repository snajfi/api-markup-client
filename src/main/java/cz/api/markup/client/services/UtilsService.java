package cz.api.markup.client.services;

import javax.ejb.Stateless;

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

}
