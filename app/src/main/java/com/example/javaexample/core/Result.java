package com.example.javaexample.core;

import org.jetbrains.annotations.NotNull;

public class Result<T> {

    class Loading extends Result<T> {}

    class Success extends Result<T> {
        @NotNull
        T data;

        public Success(T data) {
            this.data = data;
        }
    }

    class Failure extends Result<T> {
        @NotNull
        Exception exception;

        public Failure(Exception exception) {
            this.exception = exception;
        }
    }

}
