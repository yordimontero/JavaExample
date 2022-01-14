package com.example.javaexample.core;

public interface RetrofitSuccessListener {
    /*
        Interface que devuelve el resultado de un response de Retrofit.
    */
    void onRetrofitSuccess(boolean isSuccess, int code, String errorMessage);
}
