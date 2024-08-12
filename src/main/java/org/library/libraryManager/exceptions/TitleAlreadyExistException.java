package org.library.libraryManager.exceptions;

public class TitleAlreadyExistException extends RuntimeException {
    public TitleAlreadyExistException(String message) {
        super(message);
    }
}
