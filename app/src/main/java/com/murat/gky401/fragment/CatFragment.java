package com.murat.gky401.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.murat.gky401.R;
import com.murat.gky401.adapter.CatsAdapter;
import com.murat.gky401.adapter.SehirAdapter;
import com.murat.gky401.model.Cat;
import com.murat.gky401.model.Sehir;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CatFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Cat> cats = new ArrayList<>();
    private CatsAdapter catsAdapter;


    private final String API_LINK = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

    public CatFragment() {
        // Required empty public constructor
    }

    public static CatFragment newInstance() {
        CatFragment fragment = new CatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCats();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvCats);
        catsAdapter = new CatsAdapter(cats, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(catsAdapter);
    }

    private void getCats(){
        cats.clear();
        StringRequest request = new StringRequest(API_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String strings) {

                try {
                    JSONObject jsonObject = new JSONObject(strings);
                    JSONArray jsonArray = jsonObject.getJSONArray("hits");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);

                        String id = jo.getString("id");
                        String sahibi = jo.getString("user");
                        String image = jo.getString("previewURL");
                        int likes = jo.getInt("likes");

                        cats.add(new Cat(id, image, sahibi, likes));
                        Log.d("SAHIBI", sahibi);
                        catsAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(), "Lütfen daha sonra deneyiniz", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(getActivity());
        rQueue.add(request);
    }
}
