package com.example.javaexample.data.local.productdb;

import com.example.javaexample.data.model.Product;

public interface ProductDBHandlerDataSource {
    void createProduct(Product product);
    void deleteProduct(String productName);
    String dbToString();
}
