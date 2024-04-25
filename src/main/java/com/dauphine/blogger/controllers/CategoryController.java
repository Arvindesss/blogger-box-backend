package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requests.ElementRequest;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping("/")
    public void createCategory(@RequestBody ElementRequest elementRequest){
        categoryService.createCategory(elementRequest);
    }

    @PatchMapping("/")
    public void updateCategoryName(@RequestParam int id, @RequestParam String name){
        categoryService.updateCategoryName(id,name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }
}
