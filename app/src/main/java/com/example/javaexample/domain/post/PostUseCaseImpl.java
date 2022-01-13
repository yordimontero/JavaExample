package com.example.javaexample.domain.post;

import com.example.javaexample.data.model.Post;
import com.example.javaexample.data.post.PostDataSource;

import java.util.List;
import retrofit2.Call;

public class PostUseCaseImpl implements PostUseCase {

    PostDataSource dataSource;

    public PostUseCaseImpl(PostDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Call<List<Post>> getPostsList() {
        return dataSource.getPostsList();
    }

}
