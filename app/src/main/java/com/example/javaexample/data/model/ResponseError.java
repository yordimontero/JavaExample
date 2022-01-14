package com.example.javaexample.data.model;

public class ResponseError {
    /*
        Objecto ResponseError.
        Este Objecto es utilizado para obtener un error de errorBody de Retrofit.
        Esto es equivalente en Kotlin a:
        data class ResponseError(
            val error: String
        )
    */

    String error;

    public ResponseError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
