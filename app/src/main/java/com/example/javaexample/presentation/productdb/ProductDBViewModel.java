package com.example.javaexample.presentation.productdb;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.javaexample.data.model.Product;
import com.example.javaexample.domain.productdb.ProductDBUseCase;

public class ProductDBViewModel extends ViewModel {

    ProductDBUseCase useCase;
    MutableLiveData<String> result;

    public ProductDBViewModel(ProductDBUseCase useCase) {
        this.useCase = useCase;
        result = new MutableLiveData<>();
    }

    public void createProduct(Product product) {
        /*
            Método para crear un producto en la base de datos.
        */
        useCase.createProduct(product);
    }

    public void deleteProduct(String productName) {
        /*
            Método para eliminar un producto en la base de datos.
        */
        useCase.deleteProduct(productName);
    }

    public MutableLiveData<String> dbToString() {
        /*
            Método para convertir la base de datos a String.
        */
        result.setValue(useCase.dbToString());
        return result;
    }

}
