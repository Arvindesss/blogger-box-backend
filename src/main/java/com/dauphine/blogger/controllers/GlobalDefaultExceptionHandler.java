package com.dauphine.blogger.controllers;

import com.dauphine.blogger.services.exceptions.CategoryAlreadyExistsException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByNameException;
import com.dauphine.blogger.services.exceptions.PostNotFoundByIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler({
            CategoryNotFoundByIdException.class,
            CategoryNotFoundByNameException.class,
            PostNotFoundByIdException.class
    })
    public ResponseEntity<String> handleNotFoundException(Exception ex){
        logger.warn("[NOT FOUND] {}", ex.getMessage());
        return ResponseEntity
                .status(404)
                .body(ex.getMessage());
    }

    @ExceptionHandler({
           CategoryAlreadyExistsException.class
    })
    public ResponseEntity<String> handleCategoryAlreadyExistsException(Exception ex){
        logger.warn("[ALREADY EXISTS] {}", ex.getMessage());
        return ResponseEntity
                .status(400)
                .body(ex.getMessage());
    }
}
