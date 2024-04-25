package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.controllers.requests.ElementRequest;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public String getCategoryById(int id) {
        return null;
    }

    @Override
    public void createCategory(ElementRequest elementRequest) {

    }

    @Override
    public void updateCategoryName(int id, String name) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
