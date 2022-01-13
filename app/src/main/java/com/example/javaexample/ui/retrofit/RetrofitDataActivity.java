package com.example.javaexample.ui.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.javaexample.R;
import com.example.javaexample.data.model.Post;
import com.example.javaexample.data.post.PostDataSourceImpl;
import com.example.javaexample.data.webservice.RetrofitClient;
import com.example.javaexample.databinding.ActivityRetrofitDataBinding;
import com.example.javaexample.domain.post.PostUseCaseImpl;
import com.example.javaexample.presentation.post.PostViewModel;
import com.example.javaexample.presentation.post.PostViewModelFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitDataActivity extends AppCompatActivity {

    ActivityRetrofitDataBinding binding;
    PostViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitDataBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(
                this,
                new PostViewModelFactory(
                        new PostUseCaseImpl(
                                new PostDataSourceImpl(
                                        new RetrofitClient().initWebService()
                                )
                        )
                )
        ).get(PostViewModel.class);

        getPostsListObserver();

    }

    private void getPostsListObserver() {

        viewModel.getPostsList()
                .observe(this, new Observer<Call<List<Post>>>() {
                    @Override
                    public void onChanged(Call<List<Post>> postList) {

                        postList.enqueue(new Callback<List<Post>>() {
                            @Override
                            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                                if (!response.isSuccessful()) {
                                    Log.wtf("TAG", "Response Code: " + response.code());
                                    return;
                                }

                                List<Post> postList = response.body();

                                for (Post posts : postList) {
                                    Log.wtf(
                                            "TAG",
                                            "userId: " + posts.getUserId() +
                                                    "\n\nid: " + posts.getId() +
                                                    "\n\ntitle: " + posts.getTitle() +
                                                    "\n\nbody: " + posts.getBody()
                                    );
                                }

                            }

                            @Override
                            public void onFailure(Call<List<Post>> call, Throwable t) {
                                Log.wtf("TAG", "Throwable: " + t.getMessage());
                            }
                        });

                    }
                });

    }

}