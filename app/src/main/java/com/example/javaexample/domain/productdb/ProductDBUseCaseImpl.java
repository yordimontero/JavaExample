package com.example.javaexample.domain.productdb;

import com.example.javaexample.data.local.productdb.ProductDBHandlerDataSource;
import com.example.javaexample.data.model.Product;

public class ProductDBUseCaseImpl implements ProductDBUseCase {

    ProductDBHandlerDataSource dataSource;

    public ProductDBUseCaseImpl(ProductDBHandlerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createProduct(Product product) {
        /*
            Método para crear un producto en la base de datos.
        */
        dataSource.createProduct(product);
    }

    @Override
    public void deleteProduct(String productName) {
        /*
            Método para eliminar un producto en la base de datos.
        */
        dataSource.deleteProduct(productName);
    }

    @Override
    public String dbToString() {
        /*
            Método para convertir la base de datos a String.
        */
        return dataSource.dbToString();
    }

}
