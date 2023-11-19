package com.inventory.demo.service.impl;

import com.inventory.demo.model.Category;
import com.inventory.demo.repository.CategoryRepository;
import com.inventory.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category edictCategoryById(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
        Category categoryEdict = categoryOptional.get();
        categoryEdict.setName(category.getName());
        categoryEdict.setDescription(category.getDescription());
        return categoryRepository.save(categoryEdict);
    }
}
