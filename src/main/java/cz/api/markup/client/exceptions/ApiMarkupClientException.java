package cz.api.markup.client.exceptions;

import cz.api.markup.client.utils.ErrorCode;

/**
 *  Main abstract exception of this library.
 *  All exceptions in this library should extends this exception.
 *  One of main reason is provide constructor with {@link ErrorCode}.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public abstract class ApiMarkupClientException extends Exception{

    public ApiMarkupClientException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
    }

    public ApiMarkupClientException(String message) {
        super(message);
    }

    public ApiMarkupClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
