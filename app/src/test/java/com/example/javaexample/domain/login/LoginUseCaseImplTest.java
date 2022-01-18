package com.example.javaexample.domain.login;

import static org.junit.Assert.assertEquals;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginUseCaseImplTest {

    @Mock
    private LoginUseCaseImpl useCaseImpl;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    @Before
    public void setup() {
        useCaseImpl = new LoginUseCaseImpl();
    }

    @Test
    public void isSuccessWithValidUserAndPassword() {
        Boolean actual = useCaseImpl.validateUser("tester@test.com", "123456");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void isNotSuccessWithValidUserAndPassword() {
        Boolean actual = useCaseImpl.validateUser("tester@test.com", "654321");
        Boolean expected = false;
        assertEquals(expected, actual);
    }

}