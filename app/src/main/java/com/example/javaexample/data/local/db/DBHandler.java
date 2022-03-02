package com.example.javaexample.data.local.db;

import com.example.javaexample.data.model.Product;

public interface DBHandler {
    void createProduct(Product product);
    void deleteProduct(String productName);
    String dbToString();
}
