package com.example.javaexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaexample.core.BaseViewHolder;
import com.example.javaexample.databinding.RecyclerviewItemRowBinding;
import com.example.javaexample.model.Person;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public interface PersonClickListener {
        /*
            Interface para detectar clicks en el RecyclerView.
        */
        void onPersonClickListener(Person person);
    }

    private static PersonClickListener personClick;
    private final List<Person> personList;

    public RecyclerViewAdapter(List<Person> personList, PersonClickListener listener) {
        /*
            Constructor del RecyclerViewAdapter.
            Esto es equivalente en Kotlin a:
            class RecyclerViewAdapter(
                private val personClick: PersonClickListener,
                private val personList: List<Person>
            )
        */
        personClick = listener;
        this.personList = personList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerviewItemRowBinding itemBinding;

        itemBinding = RecyclerviewItemRowBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        /*
            El constructor de RecyclerViewViewHolder obligadamente lleva como primer parámetro
            un View (@NonNull View itemView), por lo que se le envía el root del itemBinding.
        */
        return new RecyclerViewViewHolder(
                itemBinding.getRoot(),
                itemBinding,
                parent.getContext()
        );

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(personList.get(position));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class RecyclerViewViewHolder extends BaseViewHolder<Person> {

        RecyclerviewItemRowBinding binding;
        Context context;

        public RecyclerViewViewHolder(
                @NonNull View itemView,
                RecyclerviewItemRowBinding binding,
                Context context
        ) {
            /*
                Constructor del RecyclerViewViewHolder.
                Este lleva por defecto un View (@NonNull View itemView).
            */
            super(itemView); // View por defecto.
            this.binding = binding;
            this.context = context;
        }

        @Override
        public void bind(Person item) {
            binding.txtName.setText("Name: " + item.getName());
            //binding.txtAge.setText(Integer.toString(item.getAge()));
            binding.txtAge.setText("Age: " + item.getAge());

            binding.mainCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*
                        Obtención del item clickado.
                    */
                    personClick.onPersonClickListener(item);
                }
            });

        }

    }

}
