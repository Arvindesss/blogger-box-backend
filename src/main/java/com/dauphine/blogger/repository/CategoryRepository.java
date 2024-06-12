package com.dauphine.blogger.repository;

import com.dauphine.blogger.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("""
            SELECT category
            FROM Category category
            WHERE UPPER(category.name) LIKE UPPER(CONCAT('%', :name , '%'))
            """)
    List<Category> findAllLikeName(String name);

    Optional<Category> findByNameIgnoreCase(String name);
}
