package com.inventory.demo.service;

import com.inventory.demo.model.Category;
import com.inventory.demo.repository.CategoryRepository;
import com.inventory.demo.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Test
    void shouldGetAllCategory(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("id","name","description"));
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> categoryListData = categoryService.getAllCategory();
        Assert.isTrue(categoryListData.get(0).getId().equals("id"),"SUCCESS");
    }
    @Test
    void shouldGetCategoryById(){
        Category category = new Category("id","name","description");
        Mockito.when(categoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(category));
        Category categoryData = categoryService.getCategoryById("id");
        Assert.isTrue(categoryData.getId().equals("id"),"SUCCESS");
    }
    @Test
    void shouldSaveCategory(){
        Category category = new Category("id","name","description");
        Mockito.when(categoryRepository.save(Mockito.any(Category.class))).thenReturn(category);
        Category categoryData = categoryService.saveCategory(category);
        Assert.isTrue(categoryData.getId().equals("id"),"SUCCESS");
    }
}
