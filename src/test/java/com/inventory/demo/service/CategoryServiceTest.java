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

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void shouldSaveCategory(){
        Category category = new Category("id","name","description");
        Mockito.when(categoryRepository.save(Mockito.any(Category.class))).thenReturn(category);
        Category categoryData = categoryService.saveCategory(category);
        Assert.isTrue(categoryData.getId().equals("id"),"SUCCESS");
    }
}
