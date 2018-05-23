package cz.api.markup.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Annotation can be used like holder of detail api information.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Endpoint {

    /**
     * Field for description of provided functionality.
     * @return description
     */
    String description();

}
