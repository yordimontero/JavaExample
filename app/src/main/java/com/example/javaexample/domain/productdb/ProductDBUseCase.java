package com.example.javaexample.domain.productdb;

import com.example.javaexample.data.model.Product;

public interface ProductDBUseCase {
    void createProduct(Product product);
    void deleteProduct(String productName);
    String dbToString();
}
