package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.exceptions.CategoryAlreadyExistsException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByNameException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAll();

    List<Category> getAllLikeName(String name);

    Category getById(UUID id) throws CategoryNotFoundByIdException;

    Category getByNameIgnoreCase(String name) throws CategoryNotFoundByNameException;

    Category create(String name) throws CategoryAlreadyExistsException;

    Category updateName(UUID id, String name) throws CategoryNotFoundByIdException;

    void deleteById(UUID id) throws CategoryNotFoundByIdException;
}
