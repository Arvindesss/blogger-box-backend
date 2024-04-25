package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.controllers.requests.ElementRequest;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<String> getAllPostsByCreationDate(LocalDateTime creationDate) {
        return null;
    }

    @Override
    public List<String> getPostById(int categoryId) {
        return null;
    }

    @Override
    public void createPost(ElementRequest elementRequest) {

    }

    @Override
    public void updatePostName(int id, String name) {

    }

    @Override
    public void deletePost(int id) {

    }
}
