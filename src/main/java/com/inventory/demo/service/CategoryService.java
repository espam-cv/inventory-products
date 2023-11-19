package com.inventory.demo.service;

import com.inventory.demo.model.Category;

public interface CategoryService {
    Category getCategoryById(String id);
    Category saveCategory(Category category);
}
