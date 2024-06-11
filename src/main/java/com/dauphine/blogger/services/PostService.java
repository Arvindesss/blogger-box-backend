package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.PostNotFoundByIdException;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllByCategoryId(UUID categoryId) throws CategoryNotFoundByIdException;

    List<Post> getAll();

    List<Post> getAllByTitleOrContent(String titleOrContent);

    Post getById(UUID id) throws PostNotFoundByIdException;

    Post create(String title, String content, UUID categoryId) throws CategoryNotFoundByIdException;

    Post update(UUID id, String title, String content, UUID categoryId) throws PostNotFoundByIdException, CategoryNotFoundByIdException;

    void deleteById(UUID id) throws PostNotFoundByIdException;
}
