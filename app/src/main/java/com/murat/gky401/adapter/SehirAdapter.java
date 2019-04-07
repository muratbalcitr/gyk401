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
import com.murat.gky401.model.Sehir;
import com.murat.gky401.model.YemekList_Model;

import java.util.List;

public class SehirAdapter extends RecyclerView.Adapter<SehirAdapter.SehirHolder> {

    private List<Sehir> sehirler;
    private Context context;

    public SehirAdapter(List<Sehir> sehirler, Context context) {
        this.sehirler = sehirler;
        this.context = context;
    }

    @NonNull
    @Override
    public SehirHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.row_sehir,viewGroup,false);
        return new SehirHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SehirHolder holder, int i) {
        Sehir sehir = sehirler.get(i);
        holder.tvAdi.setText(sehir.getAdi());
        holder.tvId.setText(String.valueOf(sehir.getId()));
    }

    @Override
    public int getItemCount() {
        return sehirler.size();
    }

    static class SehirHolder extends  RecyclerView.ViewHolder {
        TextView tvId,tvAdi;

        SehirHolder(@NonNull View itemView){
            super(itemView);
            tvAdi = itemView.findViewById(R.id.tvAdi);
            tvId = itemView.findViewById(R.id.tvId);
        }
    }
}
