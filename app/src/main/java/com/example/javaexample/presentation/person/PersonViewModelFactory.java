package com.example.javaexample.presentation.person;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javaexample.domain.person.PersonUseCase;

public class PersonViewModelFactory implements ViewModelProvider.Factory {

    PersonUseCase useCase;

    public PersonViewModelFactory(PersonUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new PersonViewModel(useCase);
    }
}