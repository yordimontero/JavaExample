package com.example.javaexample.presentation.post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaexample.data.model.Post;
import com.example.javaexample.domain.post.PostUseCase;

import java.util.List;
import retrofit2.Call;

public class PostViewModel extends ViewModel {

    PostUseCase useCase;
    MutableLiveData<Call<List<Post>>> postList;

    public PostViewModel(PostUseCase useCase) {
        this.useCase = useCase;
        postList = new MutableLiveData<>();
    }

    public LiveData<Call<List<Post>>> getPostsList() {
        postList.setValue(useCase.getPostsList());
        return postList;
    }

}
