package com.example.javaexample.domain.login;

public class LoginUseCaseImpl implements LoginUseCase {

    public LoginUseCaseImpl() {}

    @Override
    public Boolean validateUser(String userName, String password) {
        return userName.equals("tester@test.com") && password.equals("123456");
    }

}
