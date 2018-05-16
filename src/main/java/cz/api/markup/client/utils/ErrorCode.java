package cz.api.markup.client.utils;

/**
 *  This enum holds all mapped error codes in lib.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public enum ErrorCode {
    CONFIG_FILE_NOT_FOUND("0001","Configuration file was not found.");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getErrorMessage() {
        return "Error " + code + " - " + message;
    }


}
