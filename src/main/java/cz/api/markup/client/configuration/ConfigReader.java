package cz.api.markup.client.configuration;


import cz.api.markup.client.utils.ErrorCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 *  Enum used for loading and reading of configuration.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public enum ConfigReader {
    CONFIG;

    private static final String CONFIGURATION_FILE_NAME = "apiMarkupConfig.yml";
    private final Log logger = LogFactory.getLog(ConfigReader.class);

    private static Map configuration;

    ConfigReader() {
        readConfiguration();
    }

    private void readConfiguration() {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE_NAME);
        if (stream==null) {
            logger.warn(ErrorCode.CONFIG_FILE_NOT_FOUND.getErrorMessage());
        }
        configuration = new Yaml().load(stream);
    }

    /**
     * @param key key name in configuration
     * @return Return value for key in configuration. Null will be return if configuration missing or
     * do not contain specific key.
     */
    public Object get(String key) {
        if (configuration==null) {
            return null;
        }
        return configuration.get(key);
    }
}
