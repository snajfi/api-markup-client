package cz.api.markup.client.exceptions;

import cz.api.markup.client.utils.ErrorCode;

/**
 *  Configuration exception should be used in case of issues with configuration reading,
 *  parsing and etc.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ConfigurationException extends ApiMarkupClientException {

    public ConfigurationException(ErrorCode errorCode) {
        super(errorCode);
    }

}
