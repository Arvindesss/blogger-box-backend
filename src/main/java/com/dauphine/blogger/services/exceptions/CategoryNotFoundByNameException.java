package com.dauphine.blogger.services.exceptions;

public class CategoryNotFoundByNameException extends Exception{
    public CategoryNotFoundByNameException(String msg) {
        super(msg);
    }
}
