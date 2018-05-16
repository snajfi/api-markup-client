package cz.api.markup.client.configuration;


import cz.api.markup.client.exceptions.ConfigurationException;
import cz.api.markup.client.utils.ErrorCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;

/**
 *  Class used for loading and reading of configuration.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ConfigurationReader {

    private static final String CONFIGURATION_FILE_NAME = "apiMarkupConfig.yml";

    private final Log logger = LogFactory.getLog(ConfigurationReader.class);

    public void readConfiguration() throws ConfigurationException {
        readConfiguration(CONFIGURATION_FILE_NAME);
    }

    public void readConfiguration(String configFileName) throws ConfigurationException {

        InputStream stream;
        if (configFileName==null || configFileName.isEmpty()) {
            logger.warn("Invalid configuration file name. Default config file name will be used.");
            stream = this.getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE_NAME);
        } else {
            stream = this.getClass().getClassLoader().getResourceAsStream(configFileName);
        }

        if (stream==null) {
            throw new ConfigurationException(ErrorCode.CONFIG_FILE_NOT_FOUND);
        } else {
            //TODO: next step of implementation
        }

    }
}
