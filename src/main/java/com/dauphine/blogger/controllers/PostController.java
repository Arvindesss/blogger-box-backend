package com.dauphine.blogger.controllers;


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

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.getAll();
    }

    @GetMapping("/{categoryId}")
    public List<Post> getPostsByCategoryId(@PathVariable UUID categoryId){
        return postService.getAllByCategoryId(categoryId);
    }

    @PostMapping("/")
    public Post createPost(@RequestBody String title, @RequestBody String content, @RequestBody UUID categoryId){
        return postService.create(title,content,categoryId);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody String title, @RequestBody String content){
        return postService.update(id,title,content);
    }

    @DeleteMapping("/{id}")
    public UUID deletePost(@PathVariable UUID id){
        return postService.deleteById(id)?id:null;
    }
}
