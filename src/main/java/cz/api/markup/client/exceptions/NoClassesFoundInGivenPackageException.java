package cz.api.markup.client.exceptions;

import cz.api.markup.client.utils.ErrorCode;

/**
 *  Custom exception.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class NoClassesFoundInGivenPackageException extends ApiMarkupClientException {

    public NoClassesFoundInGivenPackageException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NoClassesFoundInGivenPackageException(String message) {
        super(message);
    }

    public NoClassesFoundInGivenPackageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoClassesFoundInGivenPackageException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
