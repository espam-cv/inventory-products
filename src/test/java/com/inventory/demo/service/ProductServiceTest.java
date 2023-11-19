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
        List<Product> categoryListData = productService.getAllProduct();
        Assert.isTrue(categoryListData.get(0).getId().equals("id"),"SUCCESS");
    }
}
