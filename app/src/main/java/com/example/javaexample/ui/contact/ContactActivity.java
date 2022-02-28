package com.example.javaexample.ui.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.javaexample.data.model.Contact;
import com.example.javaexample.data.remote.contact.ContactDataSourceImpl;
import com.example.javaexample.databinding.ActivityContactBinding;
import com.example.javaexample.domain.contact.ContactUseCaseImpl;
import com.example.javaexample.presentation.contact.ContactViewModel;
import com.example.javaexample.presentation.contact.ContactViewModelFactory;

import java.util.List;

public class ContactActivity extends AppCompatActivity {

    ActivityContactBinding binding;
    ContactViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(
                this,
                new ContactViewModelFactory(
                        new ContactUseCaseImpl(
                                new ContactDataSourceImpl()
                        )
                )
        ).get(ContactViewModel.class);

        getContactsList();

    }

    private void getContactsList() {

        viewModel.getContactsList(
                this
        ).observe(
                this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(List<Contact> contacts) {

                        if (contacts.size() != 0) {

                            for (int i = 0; i < contacts.size(); i++) {
                                Log.wtf("TAG", contacts.get(i).getName() + "\n");
                                Toast.makeText(getApplicationContext(), contacts.get(i).getName(), Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                }
        );
    }
}