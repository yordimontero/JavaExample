package com.example.javaexample.domain.post;

import com.example.javaexample.data.model.Post;

import java.util.List;

import retrofit2.Call;

public interface PostUseCase {
    Call<List<Post>> getPostsList();
}
