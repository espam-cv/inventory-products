package com.inventory.demo.service;

import com.inventory.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(String id);
    Category saveCategory(Category category);
}
