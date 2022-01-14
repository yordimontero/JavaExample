package com.example.javaexample.ui.post.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaexample.core.BaseViewHolder;
import com.example.javaexample.data.model.Post;
import com.example.javaexample.databinding.PostItemRawBinding;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    /*
        Esto es equivalente en Kotlin a:
        class PostAdapter(
                private val postList: List<Post>
            ): RecyclerView.Adapter<BaseViewHolder<*>>()
    */
    private List<Post> postList;

    public PostAdapter(List<Post> postList) {
        /*
            Constructor.
        */
        this.postList = postList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        PostItemRawBinding itemBinding = PostItemRawBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        /*
            El constructor de PostAdapterViewHolder obligadamente lleva como primer parámetro
            un View (@NonNull View itemView), por lo que se le envía el root del itemBinding.
        */
        return new PostAdapterViewHolder(
                itemBinding.getRoot(),
                itemBinding,
                parent.getContext()
        );

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {return postList.size();}

    public static class PostAdapterViewHolder extends BaseViewHolder<Post> {

        PostItemRawBinding binding;
        Context context;

        public PostAdapterViewHolder(
                @NonNull View itemView,
                PostItemRawBinding binding,
                Context context
        ) {
            /*
                Constructor del PostAdapterViewHolder.
                Este lleva por defecto un View (@NonNull View itemView).
            */
            super(itemView); // View por defecto.
            this.binding = binding;
            this.context = context;
        }

        @Override
        public void bind(Post item) {

            binding.txtUserId.setText(Integer.toString(item.getUserId()));
            binding.txtId.setText(Integer.toString(item.getId()));
            binding.txtTitle.setText(item.getTitle());
            binding.txtBody.setText(item.getBody());

        }

    }

}
