package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requestbody.CategoryRequestBody;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> getAllCategories(@RequestParam(required = false) String name){
        return name == null || name.isBlank() ? categoryService.getAll() : categoryService.getAllByName(name);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable UUID id){
        return categoryService.getById(id);
    }

    @PostMapping("")
    public Category createCategory(@RequestBody CategoryRequestBody category){
        return categoryService.create(category.name());
    }

    @PutMapping("/{id}")
    public Category updateCategoryName(@PathVariable UUID id, @RequestBody CategoryRequestBody category){
       return categoryService.updateName(id,category.name());
    }

    @DeleteMapping("/{id}")
    public UUID deleteCategory(@PathVariable UUID id){
        return categoryService.deleteById(id)?id:null;
    }
}
