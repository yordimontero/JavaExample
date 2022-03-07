package com.example.javaexample.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.javaexample.ui.book.BookLibraryActivity;
import com.example.javaexample.ui.contact.ContactActivity;
import com.example.javaexample.ui.main.adapter.RecyclerViewAdapter;
import com.example.javaexample.data.local.person.PersonDataSourceImpl;
import com.example.javaexample.databinding.ActivityMainBinding;
import com.example.javaexample.data.model.Person;
import com.example.javaexample.domain.person.PersonUseCaseImpl;
import com.example.javaexample.presentation.person.PersonViewModel;
import com.example.javaexample.presentation.person.PersonViewModelFactory;
import com.example.javaexample.ui.post.PostActivity;
import com.example.javaexample.ui.product.ProductActivity;

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

        binding.btnGeneratePersonList.setOnClickListener(this);
        binding.btnGoToRetrofitActivity.setOnClickListener(this);
        binding.btnGoToVolleyActivity.setOnClickListener(this);
        binding.btnGoToSqlActivity.setOnClickListener(this);
        binding.btnGoToBookLibraryActivity.setOnClickListener(this);

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
        if (binding.btnGeneratePersonList.equals(view)) {
            getPersonListObserver();
            return;
        }

        if (binding.btnGoToRetrofitActivity.equals(view)) {
            goToRetrofitActivity();
        }

        if (binding.btnGoToVolleyActivity.equals(view)) {
            goToVolleyActivity();
        }

        if (binding.btnGoToSqlActivity.equals(view)) {
            goToSQLActivity();
        }

        if (binding.btnGoToBookLibraryActivity.equals(view)) {
            goToBookLibraryActivity();
        }

    }

    private void getPersonListObserver() {
        /*
            Método encargado de obtener la lista de personas del ViewModel y atacharle un Observer.
        */
        viewModel.getPersonList().observe(this, personList ->
                recyclerViewSetup(personList)
        );
    }

    private void recyclerViewSetup(List<Person> personList) {
        adapter = new RecyclerViewAdapter(personList, this);
        binding.rvNumbers.setAdapter(adapter);
    }

    private void goToRetrofitActivity() {
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }

    private void goToVolleyActivity() {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    private void goToSQLActivity() {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    private void goToBookLibraryActivity() {
        Intent intent = new Intent(this, BookLibraryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPersonClickListener(Person person) {
        /*
            Método encargado de controlar el click en el RecyclerView.
        */
        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }

}