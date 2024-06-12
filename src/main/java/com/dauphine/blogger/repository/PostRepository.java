package com.dauphine.blogger.repository;

import com.dauphine.blogger.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByCategoryId(UUID uuid);

    @Query(value = """
           SELECT *
           FROM POST p
           WHERE UPPER(p.title) LIKE UPPER(CONCAT('%', :title , '%'))
           """,
            nativeQuery = true
    )
    List<Post> findAllLikeTitle(String title);

    @Query(value = """
           SELECT *
           FROM POST p
           ORDER BY p.created_date DESC
           """,
            nativeQuery = true
    )
    List<Post> findAllOrderByCreatedDateDesc();
}
