package com.inventory.demo.controller;

import com.inventory.demo.model.Product;
import com.inventory.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteProductById(String id){
        productService.deleteProductById(id);
        System.out.printf(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
