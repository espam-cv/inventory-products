package com.inventory.demo.controller;

import com.inventory.demo.model.Category;
import com.inventory.demo.model.Product;
import com.inventory.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;
    @Test
    void shouldGetAllProduct(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("id","mesa","mesa1",new Category(),Boolean.TRUE));
        Mockito.when(productService.getAllProduct()).thenReturn(productList);
        ResponseEntity<?> responseEntity = productController.getAllProduct();
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.OK),"SUCCESS");
    }
    @Test
    void shouldSaveProduct(){
        Product product = new Product("id","mesa","mesa1",new Category(),Boolean.TRUE);
        Mockito.when(productService.saveProduct(Mockito.any(Product.class))).thenReturn(product);
        ResponseEntity<?> responseEntity = productController.saveProduct(product);
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.CREATED),"SUCCESS");
    }
    @Test
    void shouldEdictProduct(){
        Product product = new Product("id","mesa","mesa1",new Category(),Boolean.TRUE);
        Mockito.when(productService.edictProductById(Mockito.any(Product.class))).thenReturn(product);
        ResponseEntity<?> responseEntity = productController.edictProductById(product);
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.OK),"SUCCESS");
    }
    @Test
    void shouldDelete(){
        Mockito.doNothing().when(productService).deleteProductById(Mockito.any(String.class));
        ResponseEntity<?> responseEntity = productController.deleteProductById("id");
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.OK),"SUCCESS");
    }
}
