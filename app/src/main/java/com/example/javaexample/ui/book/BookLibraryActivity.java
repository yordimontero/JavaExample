package com.example.javaexample.ui.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.javaexample.R;
import com.example.javaexample.databinding.ActivityBookLibraryBinding;

public class BookLibraryActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityBookLibraryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookLibraryBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnAddBook.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (binding.btnAddBook.equals(view)) {
            goToAddBookActivity();
        }

    }

    private void goToAddBookActivity() {
        Intent intent = new Intent(BookLibraryActivity.this, AddBookActivity.class);
        startActivity(intent);
    }

}