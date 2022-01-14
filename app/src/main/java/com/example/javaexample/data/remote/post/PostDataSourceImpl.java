package com.example.javaexample.data.remote.post;

import com.example.javaexample.core.RetrofitSuccessListener;
import com.example.javaexample.data.model.Post;
import com.example.javaexample.data.webservice.WebService;

import java.util.List;
import retrofit2.Call;

public class PostDataSourceImpl implements PostDataSource {
    /*
        Esto es equivalente en Kotlin a:
        class PostDataSourceImpl: PersonDataSource
    */
    WebService webService;
    RetrofitSuccessListener listener;

    public PostDataSourceImpl(WebService webService, RetrofitSuccessListener listener) {
        /*
            Constructor.
        */
        this.webService = webService;
        this.listener = listener;
    }

    @Override
    public Call<List<Post>> getPostsList() {
        /*
            Método encargado de obtener una lista de posts de una API REST.
        */
        return webService.getPostsList();
    }

}
