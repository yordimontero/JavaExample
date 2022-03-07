package com.example.javaexample.presentation.productdb;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javaexample.domain.productdb.ProductDBUseCase;

public class ProductDBViewModelFactory implements ViewModelProvider.Factory {

    ProductDBUseCase useCase;

    public ProductDBViewModelFactory(ProductDBUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new ProductDBViewModel(useCase);
    }

}
