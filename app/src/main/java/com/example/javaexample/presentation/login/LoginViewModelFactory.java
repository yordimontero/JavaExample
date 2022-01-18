package com.example.javaexample.presentation.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javaexample.domain.login.LoginUseCase;

public class LoginViewModelFactory implements ViewModelProvider.Factory {

    LoginUseCase useCase;

    public LoginViewModelFactory(LoginUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new LoginViewModel(useCase);
    }

}
