package com.example.javaexample.presentation.post;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.javaexample.domain.post.PostUseCase;

public class PostViewModelFactory implements ViewModelProvider.Factory {

    PostUseCase useCase;

    public PostViewModelFactory(PostUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new PostViewModel(useCase);
    }

}
