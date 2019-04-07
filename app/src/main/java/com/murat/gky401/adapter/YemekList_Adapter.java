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
import com.murat.gky401.model.YemekList_Model;

import java.util.List;

public class YemekList_Adapter extends RecyclerView.Adapter<YemekList_Adapter.YemekHolder> {

    private List<YemekList_Model> yemekList_models;
    private Context context;

    public YemekList_Adapter(List<YemekList_Model> yemekList_models, Context context) {
        this.yemekList_models = yemekList_models;
        this.context = context;
    }

    @NonNull
    @Override
    public YemekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.yemek_list_item,viewGroup,false);
        return new YemekHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull YemekHolder holder, int i) {
        YemekList_Model yemekList_model = yemekList_models.get(i);
        holder.tvHazirlama.setText(String.valueOf(yemekList_model.getHazirlamaSuresi()));
        holder.tvKisiSayisi.setText(String.valueOf(yemekList_model.getKisiSayisi()));
        holder.tvPisme.setText(String.valueOf(yemekList_model.getPismeSuresi()));
        holder.tvYemekAdi.setText(String.valueOf(yemekList_model.getYemekadi()));

        // adding image witjh glide library
        Glide.with(context)
                .load("https://b.zmtcdn.com/data/pictures/chains/7/5911957/15a43b4d60b3b3311bbadaa085bfca04.jpg")
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return yemekList_models.size();
    }

    static class YemekHolder extends  RecyclerView.ViewHolder {
        TextView tvKisiSayisi,tvHazirlama,tvPisme,tvYemekAdi;
        ImageView imageView;

        YemekHolder(@NonNull View itemView){
            super(itemView);
            tvKisiSayisi = itemView.findViewById(R.id.tvKisiSayisi);
            tvHazirlama = itemView.findViewById(R.id.tvHazirlamaSuresi);
            tvPisme = itemView.findViewById(R.id.tvPismeSuresi);
            tvYemekAdi = itemView.findViewById(R.id.tvYemekAdi);
            imageView = itemView.findViewById(R.id.imgYemekResim);
        }
    }
}
