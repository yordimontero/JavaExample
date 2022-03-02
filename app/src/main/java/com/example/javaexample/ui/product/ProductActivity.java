package com.example.javaexample.ui.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.javaexample.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnAddProduct.setOnClickListener(this);
        binding.btnDeleteProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (binding.btnAddProduct.equals(view)) {
            //...
        }

        if (binding.btnDeleteProduct.equals(view)) {
            //...
        }

    }

}