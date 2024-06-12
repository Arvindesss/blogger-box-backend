package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requestbody.CategoryRequestBody;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.services.PostService;
import com.dauphine.blogger.services.exceptions.CategoryAlreadyExistsException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByNameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    private final PostService postService;

    public CategoryController(CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name){
        List<Category> categories = name == null || name.isBlank()
                ? categoryService.getAll()
                : categoryService.getAllLikeName(name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}/posts")
    public ResponseEntity<List<Post>> getPostsByCategoryId(@PathVariable UUID categoryId) throws CategoryNotFoundByIdException {
        List<Post> posts = postService.getAllByCategoryId(categoryId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable UUID id) throws CategoryNotFoundByIdException{
            Category category = categoryService.getById(id);
            return ResponseEntity.ok(category);
    }

    @GetMapping("/name")
    public ResponseEntity<Category> getCategoryByName(String name) throws CategoryNotFoundByNameException {
        Category category = categoryService.getByNameIgnoreCase(name);
        return ResponseEntity.ok(category);
    }

    @PostMapping("")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestBody categoryRequestBody) throws CategoryAlreadyExistsException {
        Category category = categoryService.create(categoryRequestBody.name());
        return ResponseEntity
                .created(URI.create("v1/categories/" + category.getId()))
                .body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategoryName(@PathVariable UUID id, @RequestBody CategoryRequestBody categoryRequestBody) throws CategoryNotFoundByIdException {
       Category category = categoryService.updateName(id,categoryRequestBody.name());
       return ResponseEntity
               .created(URI.create("v1/categories/" + category.getId()))
               .body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id) throws CategoryNotFoundByIdException {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
