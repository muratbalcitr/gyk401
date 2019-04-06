package com.murat.gky401.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.murat.gky401.R;
import com.murat.gky401.model.YemekList_Model;

import java.util.List;

public class YemekList_Adapter extends RecyclerView.Adapter<YemekList_Adapter.YemekHolder> {
    List<YemekList_Model> yemekList_models;


    public YemekList_Adapter(List<YemekList_Model> yemekList_models){
        this.yemekList_models = yemekList_models;
    }
    @NonNull
    @Override
    public YemekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.yemek_list_item,viewGroup,false);
        return new YemekHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull YemekHolder holder, int i) {
        YemekList_Model yemekList_model = yemekList_models.get(i);
        holder.tvHazirlama.setText(yemekList_model.getHazirlamaSuresi());
        holder.tvKisiSayisi.setText(yemekList_model.getKisiSayisi());
        holder.tvPisme.setText(yemekList_model.getPismeSuresi());
        holder.tvYemekAdi.setText(yemekList_model.getYemekadi());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class YemekHolder extends  RecyclerView.ViewHolder {
        public TextView tvKisiSayisi,tvHazirlama,tvPisme,tvYemekAdi;

        public YemekHolder(@NonNull View itemView){
            super(itemView);

            tvKisiSayisi = itemView.findViewById(R.id.tvKisiSayisi);
            tvHazirlama = itemView.findViewById(R.id.tvHazirlamaSuresi);
            tvPisme = itemView.findViewById(R.id.tvPismeSuresi);
            tvYemekAdi = itemView.findViewById(R.id.tvYemekAdi);
        }
    }
}
