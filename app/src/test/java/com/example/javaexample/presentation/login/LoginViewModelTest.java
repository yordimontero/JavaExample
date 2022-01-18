package com.example.javaexample.presentation.login;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.example.javaexample.domain.login.LoginUseCaseImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    MutableLiveData<Boolean> actual;
    MutableLiveData<Boolean> expected;

    @Mock
    private LoginUseCaseImpl useCase;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    private LoginViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = Mockito.spy(
                new LoginViewModel(useCase)
        );
        actual = new MutableLiveData<>();
        expected = new MutableLiveData<>();
    }

    @Test
    public void validUser() throws Exception {
        actual.setValue(
                viewModel.validateUser(
                        "tester@test.com",
                        "123456"
                ).getValue()
        );

        expected.setValue(true);

        assertEquals(expected.getValue(), actual.getValue());
    }

    @Test
    public void invalidUser() throws Exception {
        actual.setValue(
                viewModel.validateUser(
                        "tester@test.com",
                        "654321"
                ).getValue()
        );

        expected.setValue(false);

        assertEquals(expected.getValue(), actual.getValue());
    }

    @After
    public void unAttachViewModel() throws Exception {
        viewModel = null;
    }
}

// https://stackoverflow.com/a/58594727