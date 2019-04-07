package com.murat.gky401.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.murat.gky401.R;
import com.murat.gky401.adapter.YemekList_Adapter;
import com.murat.gky401.model.YemekList_Model;

import java.util.ArrayList;
import java.util.List;

public class Yemek_Listesi_fragment extends Fragment {

    private List<YemekList_Model> yemekList_models;
    private RecyclerView rlcYemekList;
    private YemekList_Adapter yemekList_adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        yemekList_models = new ArrayList<>();
        yemekList_models.add(new YemekList_Model("Kuru Fasülye", 180, 30, 4));
        yemekList_models.add(new YemekList_Model("İmam Bayıldı", 180, 30, 4));
        yemekList_models.add(new YemekList_Model("Mantarlı Tavuk Çorba", 45, 10, 4));
        yemekList_models.add(new YemekList_Model("Makarna", 20, 1, 3));
        yemekList_models.add(new YemekList_Model("Tiramisu", 30, 40, 2));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yemek_listesi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rlcYemekList = view.findViewById(R.id.rlcYemekList);
        yemekList_adapter = new YemekList_Adapter(yemekList_models, getContext());
        rlcYemekList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rlcYemekList.setAdapter(yemekList_adapter);
    }
}
