package com.example.javaexample.ui.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.javaexample.R;
import com.example.javaexample.databinding.ActivityAddBookBinding;

public class AddBookActivity extends AppCompatActivity {

    ActivityAddBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBookBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
    }

}