package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repository.CategoryRepository;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryServiceImplTest {

    private CategoryServiceImpl categoryService;

    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void shouldReturnCategoryWhenIdExists() throws CategoryNotFoundByIdException {
        //Arrange
        UUID id = UUID.randomUUID();
        Category expected = new Category("Category");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(expected));

        //Act
        Category actual = categoryService.getById(id);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExists() {
        //Arrange
        UUID id = UUID.randomUUID();
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        //Act
        CategoryNotFoundByIdException exception = assertThrows(
                CategoryNotFoundByIdException.class,
                () -> categoryService.getById(id)
        );

        //Assert
        assertEquals("Category with id " + id + " not found", exception.getMessage());
    }

    @Test
    void shouldCreateCategory() {
        //Arrange
        String name = "New Category";
        Category expected = new Category(name);
        when(categoryRepository.save(any())).thenReturn(expected);

        //Act
        Category actual = categoryService.create(name);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateCategoryName() throws CategoryNotFoundByIdException {
        //Arrange
        UUID id = UUID.randomUUID();

        String oldName = "Old Category";
        String newName = "New Category";


        Category oldCategory = new Category(oldName);
        Category updatedCategory = new Category(newName);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(oldCategory));
        when(categoryRepository.save(oldCategory)).thenReturn(updatedCategory);

        //Act
        Category actual = categoryService.updateName(id, newName);

        //Assert
        assertEquals(updatedCategory, actual);
    }
}