package cz.api.markup.client.tests.unit;

import cz.api.markup.client.configuration.ConfigurationReader;
import cz.api.markup.client.exceptions.ConfigurationException;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 *  Tests for {@link ConfigurationReader} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ConfigurationReaderTest {

    private ConfigurationReader configurationReader = new ConfigurationReader();

    @Test
    public void readConfigurationTestOfDefaultConfiguration(){
        try {
            configurationReader.readConfiguration();
        } catch (ConfigurationException e) {
            fail("Default configuration file was not found.");
        }
    }

    @Test(expected = ConfigurationException.class)
    public void readConfigurationTestOfNonExistingConfiguration() throws ConfigurationException {
        configurationReader.readConfiguration("nonExistingFile");
    }

}
