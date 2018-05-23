package cz.api.markup.client.exceptions;

import cz.api.markup.client.utils.ErrorCode;

/**
 *  Main abstract exception of this library.
 *  All exceptions in this library should extends this exception.
 *  One of main reason is provide constructor with {@link ErrorCode}.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
abstract class ApiMarkupClientException extends Exception{

    ApiMarkupClientException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
    }

    ApiMarkupClientException(String message) {
        super(message);
    }

    ApiMarkupClientException(String message, Throwable cause) {
        super(message, cause);
    }

    ApiMarkupClientException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorMessage(), cause);
    }
}
