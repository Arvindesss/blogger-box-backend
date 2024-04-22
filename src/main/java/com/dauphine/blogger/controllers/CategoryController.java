package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requests.ElementRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {


    @GetMapping("/")
    public List<String> getAllCategories(){
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable int id){
        return String.valueOf(id);
    }
    @PostMapping("/")
    public void createCategory(@RequestBody ElementRequest elementRequest){
        return;
    }

    @PatchMapping("/")
    public void updateCategoryName(@RequestParam int id, @RequestParam String name){
        return;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        return;
    }
}
