package com.dauphine.blogger.controllers;


import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable UUID id){
        return categoryService.getById(id);
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody String name){
        return categoryService.create(name);
    }

    @PutMapping("/{id}")
    public Category updateCategoryName(@PathVariable UUID id, @RequestBody String name){
       return categoryService.updateName(id,name);
    }

    @DeleteMapping("/{id}")
    public UUID deleteCategory(@PathVariable UUID id){
        return categoryService.deleteById(id)?id:null;
    }
}
