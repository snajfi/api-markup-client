package cz.api.markup.client.tests.unit;

import cz.api.markup.client.configuration.ConfigReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 *  Tests for {@link ConfigReader} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ConfigReaderTest {


    @Test
    public void readConfigurationTestOfDefaultConfiguration(){

        assertEquals("package.with.api",ConfigReader.INSTANCE.configuration().getApiPackage());
        assertTrue(ConfigReader.INSTANCE.configuration().getHttpMethods().size()==1);
        assertEquals("get",ConfigReader.INSTANCE.configuration().getHttpMethods().get(0));

    }


}
