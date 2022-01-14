package com.example.javaexample.presentation.post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaexample.core.RetrofitSuccessListener;
import com.example.javaexample.core.uiutils.text.TextUtils;
import com.example.javaexample.data.model.Post;
import com.example.javaexample.domain.post.PostUseCase;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    /*
        Esto es equivalente en Kotlin a:
        class PostViewModel(
            private val useCase: PostUseCase
        ): ViewModel()
    */

    PostUseCase useCase;
    MutableLiveData<List<Post>> mutablePostList;
    RetrofitSuccessListener listener;

    public PostViewModel(PostUseCase useCase) {
        /*
            Constructor.
        */
        this.useCase = useCase;
        mutablePostList = new MutableLiveData<>();
    }

    public void setInterface(RetrofitSuccessListener listener) {
        /*
            Método encargado de inicializar la interface RetrofitSuccessListener.
        */
        this.listener = listener;
    }

    public LiveData<List<Post>> getPostsList() {
        /*
            Método encargado de obtener una lista de posts de una API REST.
        */
        useCase.getPostsList().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {

                    try {

                        assert response.errorBody() != null;

                        listener.onRetrofitSuccess(
                                false,
                                response.code(),
                                new TextUtils().parseJsonToString(
                                        response.errorBody().string()
                                )
                        );

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return;
                }

                List<Post> postList = response.body();
                mutablePostList.setValue(postList);
                listener.onRetrofitSuccess(true, response.code(), null);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                listener.onRetrofitSuccess(false, 0, null);
            }
        });

        return mutablePostList;

    }

}
