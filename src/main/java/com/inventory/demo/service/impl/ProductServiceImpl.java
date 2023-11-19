package com.inventory.demo.service.impl;

import com.inventory.demo.model.Product;
import com.inventory.demo.repository.ProductRepository;
import com.inventory.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product edictProductById(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        Product productEdict = productOptional.get();
        productEdict.setName(product.getName());
        productEdict.setDescription(product.getDescription());
        productEdict.setCategory(product.getCategory());
        return productRepository.save(productEdict);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
