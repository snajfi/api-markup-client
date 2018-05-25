package cz.api.markup.client.utils;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Enum used for transforming http methods from configuration into {@link Annotation} classes.
 *
 * @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public enum EndpointAnnotations {
    ;

    private static final HashMap<String, Class<? extends Annotation>> ANNOTATIONS = new HashMap<>();

    static {
        ANNOTATIONS.put("get", GET.class);
        ANNOTATIONS.put("post", POST.class);
        ANNOTATIONS.put("put", PUT.class);
        ANNOTATIONS.put("delete", DELETE.class);
    }

    public static List<Class<? extends Annotation>> getAnnotationsForMethods(List<String> httpMethods) {
        List<Class<? extends Annotation>> classes = new ArrayList<>();
        for (String method : httpMethods) {
            if (ANNOTATIONS.containsKey(method.toLowerCase())) {
                classes.add(ANNOTATIONS.get(method.toLowerCase()));
            }
        }
        return classes;
    }

    public static List<Class<? extends Annotation>> getAllAnnotationClasses() {
        return new ArrayList<>(ANNOTATIONS.values());
    }

}
