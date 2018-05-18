package cz.api.markup.client.configuration;


import cz.api.markup.client.pojos.ConfigurationPojo;
import cz.api.markup.client.utils.ErrorCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Arrays;

/**
 *  Enum used for loading and reading of configuration.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public enum ConfigReader {
    INSTANCE;

    private static final String CONFIGURATION_FILE_NAME = "apiMarkupConfig.yml";
    private final Log logger = LogFactory.getLog(ConfigReader.class);

    private ConfigurationPojo defaultConfiguration;
    private ConfigurationPojo configuration;

    ConfigReader() {
        fillInDefaultConfiguration();
        readConfiguration();
    }

    private void fillInDefaultConfiguration() {

        defaultConfiguration = new ConfigurationPojo();
        defaultConfiguration.setApiPackage("");
        defaultConfiguration.setHttpMethods(Arrays.asList("GET","POST","UPDATE","DELETE"));

    }

    private void readConfiguration() {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE_NAME);
        if (stream==null) {
            logger.warn(ErrorCode.CONFIG_FILE_NOT_FOUND.getErrorMessage());
        } else {
            Constructor constructor = new Constructor(ConfigurationPojo.class);
            TypeDescription carDescription = new TypeDescription(ConfigurationPojo.class);
            constructor.addTypeDescription(carDescription);

            Yaml yaml = new Yaml(constructor);
            configuration = yaml.load(stream);
        }
    }

    public ConfigurationPojo configuration() {
        if (configuration==null) {
            return defaultConfiguration;
        }
        return configuration;
    }

}
