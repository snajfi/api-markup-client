package cz.api.markup.client.tests.unit.utils;

import cz.api.markup.client.utils.EndpointAnnotations;
import org.junit.Test;

import javax.ws.rs.GET;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

/**
 *  Tests for {@link EndpointAnnotations} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class EndpointAnnotationsTest {

    @Test
    public void getAnnotationsForMethodsTest() {

        assertTrue(EndpointAnnotations.getAnnotationsForMethods(Collections.singletonList("get")).contains(GET.class));
        assertTrue(EndpointAnnotations.getAnnotationsForMethods(Collections.singletonList("Get")).contains(GET.class));
        assertTrue(EndpointAnnotations.getAnnotationsForMethods(Collections.singletonList("GET")).contains(GET.class));

        assertTrue(EndpointAnnotations.getAnnotationsForMethods(Collections.singletonList("nonsense")).isEmpty());

    }

}
