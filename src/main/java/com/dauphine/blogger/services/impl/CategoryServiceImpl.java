package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repository.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.services.exceptions.CategoryAlreadyExistsException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByNameException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllLikeName(String name) {
        return categoryRepository.findAllLikeName(name);
    }

    public Category getById(UUID id) throws CategoryNotFoundByIdException {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundByIdException("Category with id "
                + id + " not found"));
    }

    @Override
    public Category getByNameIgnoreCase(String name) throws CategoryNotFoundByNameException {
        return categoryRepository.findByNameIgnoreCase(name).orElseThrow(() ->
                new CategoryNotFoundByNameException("Category with name " + name + " not found"));
    }

    @Override
    public Category create(String name) throws CategoryAlreadyExistsException {
        if(categoryRepository.findByNameIgnoreCase(name).isPresent()) {
            throw new CategoryAlreadyExistsException("Category with name " + name + " already exists");
        };
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateName(UUID id, String name) throws CategoryNotFoundByIdException {
        Category category = getById(id);
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(UUID id) throws CategoryNotFoundByIdException {
        getById(id);
        categoryRepository.deleteById(id);
    }
}
