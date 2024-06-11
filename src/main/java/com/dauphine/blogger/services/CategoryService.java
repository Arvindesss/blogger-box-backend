package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAll();

    List<Category> getAllByName(String name);

    Category getById(UUID id) throws CategoryNotFoundByIdException;

    Category create(String name);

    Category updateName(UUID id, String name) throws CategoryNotFoundByIdException;

    void deleteById(UUID id) throws CategoryNotFoundByIdException;
}
