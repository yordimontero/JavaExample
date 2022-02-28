package com.example.javaexample.presentation.contact;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javaexample.domain.contact.ContactUseCase;

public class ContactViewModelFactory implements ViewModelProvider.Factory {

    ContactUseCase useCase;

    public ContactViewModelFactory(ContactUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new ContactViewModel(useCase);
    }

}
