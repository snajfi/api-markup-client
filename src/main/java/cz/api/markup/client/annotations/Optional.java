package cz.api.markup.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Annotation used as marker for parameters, which are optional.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Optional  {

}
