package com.dauphine.blogger.services;

import com.dauphine.blogger.controllers.requests.ElementRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {

    @GetMapping("/")
    public List<String> getAllCategories();

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable int id);
    @PostMapping("/")
    public void createCategory(@RequestBody ElementRequest elementRequest);

    @PatchMapping("/")
    public void updateCategoryName(@RequestParam int id, @RequestParam String name);

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id);
}
