package cz.api.markup.client.exceptions;

import cz.api.markup.client.utils.ErrorCode;

/**
 *  Custom exception.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class CanNotGetClassesException extends ApiMarkupClientException {

    public CanNotGetClassesException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CanNotGetClassesException(String message) {
        super(message);
    }

    public CanNotGetClassesException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotGetClassesException(ErrorCode errorCode,Throwable cause) {
        super(errorCode,cause);
    }
}
