package com.inventory.demo.controller;

import com.inventory.demo.model.Category;
import com.inventory.demo.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;
    @InjectMocks
    private CategoryController categoryController;
    @Test
    void shouldGetCategoryById(){
        Category category = new Category("id","name","description");
        Mockito.when(categoryService.getCategoryById(Mockito.anyString())).thenReturn(category);
        ResponseEntity<?> responseEntity = categoryController.getCategoryById("id");
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.OK),"SUCCESS");
    }
    @Test
    void shouldSaveCategory(){
        Category category = new Category("id","name","description");
        Mockito.when(categoryService.saveCategory(Mockito.any(Category.class))).thenReturn(category);
        ResponseEntity<?> responseEntity = categoryController.saveCategory(category);
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.CREATED),"SUCCESS");
    }
}
