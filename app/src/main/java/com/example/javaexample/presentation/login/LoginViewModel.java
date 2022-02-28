package com.example.javaexample.presentation.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaexample.domain.login.LoginUseCase;
import com.example.javaexample.ui.login.Login;
import com.example.javaexample.ui.login.TestInterfaceImpl;

public class LoginViewModel extends ViewModel {

    LoginUseCase useCase;
    MutableLiveData<Boolean> validateUser;
    Login.ViewModel viewModelInterface;

    public LoginViewModel(LoginUseCase useCase) {
        this.useCase = useCase;
        validateUser = new MutableLiveData<>();
        viewModelInterface = new TestInterfaceImpl();
    }

    public LiveData<Boolean> validateUser(String userName, String password) {
        validateUser.setValue(useCase.validateUser(userName, password));

        if (validateUser.getValue()) {
            viewModelInterface.success();
        } else {
            viewModelInterface.failure();
        }

        return validateUser;
    }

}
