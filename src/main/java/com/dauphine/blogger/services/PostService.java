package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllByCategoryId(UUID categoryId);

    List<Post> getAll();

    List<Post> getAllByTitleOrContent(String titleOrContent);

    Post getById(UUID id);

    Post create(String title, String content, UUID categoryId);

    Post update(UUID id, String title, String content);

    boolean deleteById(UUID id);
}
