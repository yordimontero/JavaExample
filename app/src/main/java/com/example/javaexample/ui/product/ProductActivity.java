package com.example.javaexample.ui.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.javaexample.data.local.productdb.ProductDBHandlerDataSourceImpl;
import com.example.javaexample.data.model.Product;
import com.example.javaexample.databinding.ActivityProductBinding;
import com.example.javaexample.domain.productdb.ProductDBUseCaseImpl;
import com.example.javaexample.presentation.productdb.ProductDBViewModel;
import com.example.javaexample.presentation.productdb.ProductDBViewModelFactory;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityProductBinding binding;

    private ProductDBViewModel productDBViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        productDBViewModel = new ViewModelProvider(
                this,
                new ProductDBViewModelFactory(
                        new ProductDBUseCaseImpl(
                                new ProductDBHandlerDataSourceImpl(
                                        this, null, null, 0
                                )
                        )
                )
        ).get(ProductDBViewModel.class);

        binding.btnAddProduct.setOnClickListener(this);
        binding.btnDeleteProduct.setOnClickListener(this);

        dbToString();

    }

    @Override
    public void onClick(View view) {

        if (binding.btnAddProduct.equals(view)) {
            createProduct();
        }

        if (binding.btnDeleteProduct.equals(view)) {
            deleteProduct();
        }

    }

    private void createProduct() {
        /*
            Método para crear un producto en la base de datos.
        */
        Product product = new Product(binding.txtProductName.getText().toString());
        productDBViewModel.createProduct(product);
        dbToString();

    }

    private void deleteProduct() {
        /*
            Método para eliminar un producto en la base de datos.
        */
        String productName = binding.txtProductName.getText().toString();
        productDBViewModel.deleteProduct(productName);
        dbToString();

    }

    private void dbToString() {
        /*
            Método para convertir la base de datos a String.
        */
        productDBViewModel.dbToString()
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String dbString) {
                        binding.txtSavedProduct.setText(dbString);
                    }
                });

    }

}