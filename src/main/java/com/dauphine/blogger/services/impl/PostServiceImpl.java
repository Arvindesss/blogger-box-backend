package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repository.CategoryRepository;
import com.dauphine.blogger.repository.PostRepository;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return postRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllByTitleOrContent(String titleOrContent) {
        return postRepository.findAllByTitleOrContent(titleOrContent,titleOrContent);
    }

    @Override
    public Post getById(UUID id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()) {
            Post post = new Post(title, content, category.get());
            return postRepository.save(post);
        }
        else throw new RuntimeException("Category " + categoryId + "not found");
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if(post == null){
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        postRepository.deleteById(id);
        return true;
    }
}
