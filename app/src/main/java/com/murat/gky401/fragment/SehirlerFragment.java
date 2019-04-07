package com.murat.gky401.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.murat.gky401.adapter.SehirAdapter;
import com.murat.gky401.model.Sehir;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SehirlerFragment extends Fragment {

    private List<Sehir> sehirler = new ArrayList<>();
    private RecyclerView rvSehirler;
    private SehirAdapter sehirAdapter;

    private final String API_LINK = "https://ezanvakti.herokuapp.com/sehirler?ulke=2";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSehirler();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sehirler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSehirler = view.findViewById(R.id.rvSehirler);
        sehirAdapter = new SehirAdapter(sehirler, getContext());
        rvSehirler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvSehirler.setAdapter(sehirAdapter);
    }


    private void getSehirler(){
        sehirler.clear();
        StringRequest request = new StringRequest(API_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String strings) {

                try {
                    JSONArray jsonArray = new JSONArray(strings);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = jsonObject.getInt("SehirID");
                        String adi = jsonObject.getString("SehirAdi");

                        sehirler.add(new Sehir(id, adi));
                        sehirAdapter.notifyDataSetChanged();
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
