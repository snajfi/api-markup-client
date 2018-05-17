package cz.api.markup.client.tests.unit;

import cz.api.markup.client.configuration.ConfigReader;
import org.junit.Test;


/**
 *  Tests for {@link ConfigReader} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ConfigReaderTest {


    @Test
    public void readConfigurationTestOfDefaultConfiguration(){
        ConfigReader.CONFIG.get("map_http_method");
        ConfigReader.CONFIG.get("output");
    }


}
