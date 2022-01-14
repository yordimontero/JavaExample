package com.example.javaexample.domain.post;

import com.example.javaexample.data.model.Post;
import com.example.javaexample.data.remote.post.PostDataSource;

import java.util.List;
import retrofit2.Call;

public class PostUseCaseImpl implements PostUseCase {
    /*
        Esto es equivalente en Kotlin a:
        class PostUseCaseImpl(
            private val dataSource: PostDataSource
        ): PostUseCase
    */
    PostDataSource dataSource;

    public PostUseCaseImpl(PostDataSource dataSource) {
        /*
            Constructor.
        */
        this.dataSource = dataSource;
    }

    @Override
    public Call<List<Post>> getPostsList() {
        /*
            Método encargado de obtener una lista de posts de una API REST.
        */
        return dataSource.getPostsList();
    }

}
