package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requestbody.CreatePostRequestBody;
import com.dauphine.blogger.controllers.requestbody.UpdatePostRequestBody;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.web.bind.annotation.*;

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
    public List<Post> getAllPosts(@RequestParam(required = false) String value){
        return value == null || value.isBlank() ? postService.getAll() : postService.getAllByTitleOrContent(value) ;
    }

    @GetMapping("/{categoryId}")
    public List<Post> getPostsByCategoryId(@PathVariable UUID categoryId){
        return postService.getAllByCategoryId(categoryId);
    }

    @PostMapping("")
    public Post createPost(@RequestBody CreatePostRequestBody createPostRequestBody){
        return postService.create(createPostRequestBody.title(), createPostRequestBody.content(), createPostRequestBody.categoryId());
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, UpdatePostRequestBody updatePostRequestBody){
        return postService.update(id, updatePostRequestBody.title(), updatePostRequestBody.content());
    }

    @DeleteMapping("/{id}")
    public UUID deletePost(@PathVariable UUID id){
        return postService.deleteById(id)?id:null;
    }
}
