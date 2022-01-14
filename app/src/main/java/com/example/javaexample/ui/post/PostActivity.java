package com.example.javaexample.ui.post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.javaexample.core.RetrofitSuccessListener;
import com.example.javaexample.data.model.Post;
import com.example.javaexample.data.remote.post.PostDataSourceImpl;
import com.example.javaexample.data.webservice.RetrofitClient;
import com.example.javaexample.databinding.ActivityPostBinding;
import com.example.javaexample.domain.post.PostUseCaseImpl;
import com.example.javaexample.presentation.post.PostViewModel;
import com.example.javaexample.presentation.post.PostViewModelFactory;
import com.example.javaexample.ui.post.adapter.PostAdapter;

import java.util.List;

import okhttp3.ResponseBody;

public class PostActivity extends AppCompatActivity implements RetrofitSuccessListener {

    ActivityPostBinding binding;
    PostViewModel viewModel;
    PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        // Instanciando ViewModel:
        viewModel = new ViewModelProvider(
                this,
                new PostViewModelFactory(
                        new PostUseCaseImpl(
                                new PostDataSourceImpl(
                                        new RetrofitClient().initWebService(),
                                        this
                                )
                        )
                )
        ).get(PostViewModel.class);

        // Instanciando la interface RetrofitSuccessListener:
        viewModel.setInterface(this);

        getPostsListObserver();

    }

    private void getPostsListObserver() {
        /*
            Método encargado de obtener una lista de posts del ViewModel y atacharle un Observer.
        */
        viewModel.getPostsList().observe(this, postList -> {
            recyclerViewSetup(postList);
        });

    }

    private void recyclerViewSetup(List<Post> postList) {
        adapter = new PostAdapter(postList);
        binding.rvPosts.setAdapter(adapter);
    }

    @Override
    public void onRetrofitSuccess(boolean isSuccess, int code, String errorMessage) {
        /*
            Interface que devuelve el resultado de un response de Retrofit.
        */
        Log.wtf("TAG", "isSuccess: " + isSuccess + ", code: " + code + ", errorMessage: " + errorMessage);

        if (errorMessage != null) {
            Toast.makeText(this, "Something went wrong: " + errorMessage, Toast.LENGTH_LONG).show();
            return;
        }

    }

}