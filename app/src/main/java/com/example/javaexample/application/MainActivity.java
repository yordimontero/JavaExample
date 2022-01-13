package com.example.javaexample.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.javaexample.ui.main.adapter.RecyclerViewAdapter;
import com.example.javaexample.data.person.PersonDataSourceImpl;
import com.example.javaexample.databinding.ActivityMainBinding;
import com.example.javaexample.data.model.Person;
import com.example.javaexample.domain.person.PersonUseCaseImpl;
import com.example.javaexample.presentation.person.PersonViewModel;
import com.example.javaexample.presentation.person.PersonViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements RecyclerViewAdapter.PersonClickListener, View.OnClickListener {

    ActivityMainBinding binding;
    PersonViewModel viewModel;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnTest.setOnClickListener(this);

        // Instanciando ViewModel:
        viewModel = new ViewModelProvider(
                this,
                new PersonViewModelFactory(
                        new PersonUseCaseImpl(
                                new PersonDataSourceImpl()
                        )
                )
        ).get(PersonViewModel.class);

    }

    @Override
    public void onClick(View view) {
        /*
            Interfaz para el manejo de clicks en componentes XML.
        */
        if (binding.btnTest.equals(view)) {
            getPersonListObserver();
            return;
        }

    }

    private void getPersonListObserver() {
        /*
            Método encargado de atachar un Observer al método venido del ViewModel.
        */
        viewModel.getPersonList().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> personList) {
                recyclerViewSetup(personList);
            }
        });

    }

    private void recyclerViewSetup(List<Person> personList) {
        adapter = new RecyclerViewAdapter(personList, this);
        binding.rvNumbers.setAdapter(adapter);
    }

    @Override
    public void onPersonClickListener(Person person) {
        /*
            Método encargado de controlar el click en el RecyclerView.
        */
        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }

}