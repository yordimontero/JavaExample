package com.example.javaexample.ui.login;

public interface Login {

    interface View {
        void initComponents();
        void validUser();
        void error();
        String getUsername();
        String getPassword();
    }

    interface ViewModel {
        void success();
        void failure();
    }

}
