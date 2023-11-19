package com.inventory.demo.service;

import com.inventory.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product saveProduct(Product product);
    void deleteProductById(String id);
}
