package org.example;

public class CensusException extends Exception {

    public enum ExceptionType {
        FILE_NOT_FOUND,
        INCORRECT_FILE_TYPE,
        DELIMITER_ISSUE,
        HEADER_ISSUE
    }

    public ExceptionType type;

    public CensusException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}