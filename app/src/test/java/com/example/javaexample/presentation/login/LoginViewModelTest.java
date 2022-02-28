package com.example.javaexample.presentation.login;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.javaexample.domain.login.LoginUseCaseImpl;
import com.example.javaexample.ui.login.LoginActivity;

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

    @Mock
    private Observer<Boolean> observer;



    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    private LoginViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = Mockito.spy(
                new LoginViewModel(useCase)
        );
        viewModel.validateUser("tester@test.com", "123456").observeForever(observer);
        actual = new MutableLiveData<>();
        expected = new MutableLiveData<>();
    }

    @Test
    public void validUser() throws Exception {

        assertFalse(viewModel.validateUser.getValue());

        //assertEquals(true, viewModel.validateUser("tester@test.com", "123456").getValue());

        /*

        viewModel.validateUser(
                "tester@test.com",
                "123456"
        ).observe(
                activity, aBoolean -> {
                    //verify(useCase).validateUser("123", "123");
                    actual.setValue(aBoolean);
                    expected.setValue(true);
                    //assertEquals(expected.getValue(), actual.getValue());
                    assertEquals(true, aBoolean);
                }
        );*/

        //expected.setValue(true);

        //verify(useCase).validateUser(anyString(), anyString());
        //assertEquals(expected.getValue(), actual.getValue());

    }

    /*@Test
    public void validUser() throws Exception {

        viewModel.validateUser(
                "tester@test.com",
                "123456"
        );

        actual.setValue(viewModel.validateUser.getValue());
        expected.setValue(true);

        verify(useCase).validateUser(anyString(), anyString());
        assertEquals(expected.getValue(), actual.getValue());

    }*/

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