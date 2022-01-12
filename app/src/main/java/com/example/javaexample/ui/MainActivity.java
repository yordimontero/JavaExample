package com.example.javaexample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.javaexample.adapter.RecyclerViewAdapter;
import com.example.javaexample.databinding.ActivityMainBinding;
import com.example.javaexample.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements RecyclerViewAdapter.PersonClickListener {

    ActivityMainBinding binding;
    List<Person> personList;
    RecyclerViewAdapter adapter;

    private void createDummyPersonList() {

        personList = new ArrayList<>();

        personList.add(
                new Person("María Rodríguez", 25)
        );
        personList.add(
                new Person("Juan Pérez", 31)
        );
        personList.add(
                new Person("Raúl Sánchez", 22)
        );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        createDummyPersonList();
        recyclerViewSetup();

    }

    private void recyclerViewSetup() {
        adapter = new RecyclerViewAdapter(personList, this);
        binding.rvNumbers.setAdapter(adapter);
    }

    @Override
    public void onPersonClickListener(Person person) {
        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }

}