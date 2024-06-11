package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requestbody.PostRequestBody;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.PostNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String value){
        List<Post> posts = value == null || value.isBlank()
                ? postService.getAll()
                : postService.getAllByTitleOrContent(value);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<Post>> getPostsByCategoryId(@PathVariable UUID categoryId) throws CategoryNotFoundByIdException {
        List<Post> posts = postService.getAllByCategoryId(categoryId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody PostRequestBody postRequestBody)
            throws CategoryNotFoundByIdException {
        Post post = postService.create(postRequestBody.title(), postRequestBody.content(),
                postRequestBody.categoryId());
        return ResponseEntity
                .created(URI.create("v1/posts" + post.getId()))
                .body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID id, PostRequestBody postRequestBody)
            throws PostNotFoundByIdException, CategoryNotFoundByIdException {
        Post post = postService.update(id, postRequestBody.title(), postRequestBody.content(), postRequestBody.categoryId());
        return ResponseEntity
                .created(URI.create("v1/posts" + post.getId()))
                .body(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable UUID id) throws PostNotFoundByIdException {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
