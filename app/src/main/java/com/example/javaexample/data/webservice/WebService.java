package com.example.javaexample.data.webservice;

import com.example.javaexample.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    /*
        Método encargado de obtener una lista de posts de una API REST.
    */
    @GET("posts")
    Call<List<Post>> getPostsList();
}