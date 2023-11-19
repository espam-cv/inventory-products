package com.inventory.demo.controller;

import com.inventory.demo.model.Category;
import com.inventory.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorys")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }
}
