package com.example.javaexample.data.webservice;

import com.example.javaexample.application.AppConstants;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static WebService webService;

    public static WebService initWebService() {
        /*
            Método encargado de inicializar la instancia de Retrofit.
        */
        if (webService == null) {

            webService = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(
                            GsonConverterFactory.create(
                                    new GsonBuilder().create()
                            )
                    ).build().create(WebService.class);

        }

        return webService;

    }

}
