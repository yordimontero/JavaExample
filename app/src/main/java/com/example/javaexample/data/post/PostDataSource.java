package com.example.javaexample.data.post;

import com.example.javaexample.data.model.Post;

import java.util.List;

import retrofit2.Call;

public interface PostDataSource {
    Call<List<Post>> getPostsList();
}
