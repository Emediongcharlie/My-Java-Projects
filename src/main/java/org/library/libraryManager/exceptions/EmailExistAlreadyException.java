package org.library.libraryManager.exceptions;

public class EmailExistAlreadyException extends RuntimeException {
    public EmailExistAlreadyException(String message) {
        super(message);
    }
}
