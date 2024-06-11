package com.dauphine.blogger.services.exceptions;

public class PostNotFoundByIdException extends Exception {
    public PostNotFoundByIdException(String msg) {
        super(msg);
    }
}
