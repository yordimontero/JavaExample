package com.example.javaexample.presentation.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaexample.domain.login.LoginUseCase;

public class LoginViewModel extends ViewModel {

    LoginUseCase useCase;
    MutableLiveData<Boolean> validateUser;

    public LoginViewModel(LoginUseCase useCase) {
        this.useCase = useCase;
        validateUser = new MutableLiveData<>();
    }

    public LiveData<Boolean> validateUser(String userName, String password) {
        validateUser.setValue(useCase.validateUser(userName, password));
        return validateUser;
    }

}
