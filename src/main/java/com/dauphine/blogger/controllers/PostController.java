package com.dauphine.blogger.controllers;


import com.dauphine.blogger.controllers.requests.ElementRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("v1/posts")
public class PostController {

    @GetMapping("/")
    public List<String> getAllPostsByCreationDate(@RequestParam LocalDateTime creationDate){
        return new ArrayList<>();
    }

    @GetMapping("/{categoryId}")
    public List<String> getPostById(@PathVariable int categoryId){
        return new ArrayList<>();
    }

    @PostMapping("/")
    public void createPost(@RequestBody ElementRequest elementRequest){
        return;
    }

    @PatchMapping("/")
    public void updatePostName(@RequestParam int id, @RequestParam String name){
        return;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable int id){
        return;
    }
}
