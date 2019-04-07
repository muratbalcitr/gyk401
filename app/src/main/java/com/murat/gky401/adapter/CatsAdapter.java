package com.murat.gky401.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.murat.gky401.R;
import com.murat.gky401.model.Cat;
import com.murat.gky401.model.Sehir;

import java.util.List;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.CatHolder> {

    private List<Cat> cats;
    private Context context;

    public CatsAdapter(List<Cat> cats, Context context) {
        this.cats = cats;
        this.context = context;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.simple_cat, viewGroup,false);
        return new CatHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int i) {
        Cat cat = cats.get(i);
        holder.tvId.setText(cat.getId());

        holder.tvSahibi.setText(cat.getOwner());
        holder.tvLikes.setText(String.valueOf(cat.getLikes()));

        Glide.with(context).load(cat.getImage()).into(holder.ivCat);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    static class CatHolder extends  RecyclerView.ViewHolder {
        ImageView ivCat;
        TextView tvId,tvSahibi, tvLikes;

        CatHolder(@NonNull View itemView){
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvSahibi = itemView.findViewById(R.id.tvSahip);
            tvLikes = itemView.findViewById(R.id.tvLikes);

            ivCat = itemView.findViewById(R.id.ivCat);
        }
    }
}
