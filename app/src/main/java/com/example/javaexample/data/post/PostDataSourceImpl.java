package com.example.javaexample.data.post;

import com.example.javaexample.data.model.Post;
import com.example.javaexample.data.webservice.WebService;

import java.util.List;
import retrofit2.Call;

public class PostDataSourceImpl implements PostDataSource {

    WebService webService;

    public PostDataSourceImpl(WebService webService) {
        this.webService = webService;
    }

    @Override
    public Call<List<Post>> getPostsList() {
        return webService.getPostsList();
    }
}
