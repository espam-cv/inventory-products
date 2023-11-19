package com.inventory.demo.service;

import com.inventory.demo.model.Category;
import com.inventory.demo.model.Product;
import com.inventory.demo.repository.ProductRepository;
import com.inventory.demo.service.impl.ProductServiceImpl;
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
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    @Test
    void shouldGetAllProduct(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("id","mesa","mesa1",new Category(),Boolean.TRUE));
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> productListData = productService.getAllProduct();
        Assert.isTrue(productListData.get(0).getId().equals("id"),"SUCCESS");
    }
    @Test
    void shouldSaveProduct(){
        Product product = new Product("id","mesa","mesa1",new Category(),Boolean.TRUE);
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        Product productData = productService.saveProduct(product);
        Assert.isTrue(productData.getId().equals("id"),"SUCCESS");
    }
    @Test
    void shouldEdictProduct(){
        Product product = new Product("id","mesa","mesa1",new Category(),Boolean.TRUE);
        Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        Product productData = productService.edictProductById(product);
        Assert.isTrue(productData.getId().equals("id"),"SUCCESS");
    }
    @Test
    void shouldDelete(){
        Mockito.doNothing().when(productRepository).deleteById(Mockito.any(String.class));
        productService.deleteProductById("id");
    }
}
