package cz.api.markup.client.tests.unit.services;

import cz.api.markup.client.services.UtilsService;
import cz.api.markup.client.tests.data.TestClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for {@link UtilsService} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class CheckUtilitiesServiceTest {

    private UtilsService checkService = new UtilsService();

    @Test
    public void isEmptyTest() {

        assertTrue(checkService.isEmpty(""));
        assertTrue(checkService.isEmpty(null));

        assertFalse(checkService.isEmpty(" "));
        assertFalse(checkService.isEmpty("l"));
    }

    @Test
    public void isNotEmptyTest() {

        assertFalse(checkService.isNotEmpty(""));
        assertFalse(checkService.isNotEmpty(null));

        assertTrue(checkService.isNotEmpty(" "));
        assertTrue(checkService.isNotEmpty("l"));
    }

    @Test
    public void simpleClassNameTest() {
        assertEquals("TestClass",checkService.simpleClassName(TestClass.class));
    }

}
