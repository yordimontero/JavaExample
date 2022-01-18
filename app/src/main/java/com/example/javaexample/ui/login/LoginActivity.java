package com.example.javaexample.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javaexample.R;
import com.example.javaexample.domain.login.LoginUseCaseImpl;
import com.example.javaexample.presentation.login.LoginViewModel;
import com.example.javaexample.presentation.login.LoginViewModelFactory;
import com.example.javaexample.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUsername, txtPassword;
    private Button btnLogin;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login: {
                validateUserObserver();
            }
        }

    }

    private void initComponents() {
        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);

        viewModel = new ViewModelProvider(
                this,
                new LoginViewModelFactory(
                        new LoginUseCaseImpl()
                )
        ).get(LoginViewModel.class);

        btnLogin.setOnClickListener(this);
    }

    private void validateUserObserver() {

        String userName = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        viewModel.validateUser(
                userName, password
        ).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isValidUser) {

                if (isValidUser) {
                    goToMainActivity();
                } else {
                    showError();
                }

            }
        });
    }

    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK
        );
        startActivity(intent);
    }

    public void showError() {
        Toast.makeText(
                this,
                "User not valid",
                Toast.LENGTH_SHORT
        ).show();
    }

}