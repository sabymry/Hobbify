package com.example.myapp.Adapter;

import com.example.myapp.domain.PopularDomain;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//import com.example.yourapp.databinding.ViewholderHobListBinding;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
     ArrayList<PopularDomain> items;
     Context context;
     ViewholderHobListBinding binding;

    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderHobListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context= parent.getContext();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularDomain item = items.get(position);
        holder.binding.titleTxt.setText(item.getTitle());
        holder.binding.feeTxt.setText(item.getPrice() + "RON");
        holder.binding.scoreTxt.setText(String.valueOf(item.getScore()));

        int drawableResourced = holder.itemView.getResources().getIdentifier(
                item.getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .info(binding.pic);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderHobListBinding binding;

        public ViewHolder(ViewholderHobListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
