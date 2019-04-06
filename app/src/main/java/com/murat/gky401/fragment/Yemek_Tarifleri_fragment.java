package com.murat.gky401.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.murat.gky401.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Yemek_Tarifleri_fragment extends Fragment {


    public Yemek_Tarifleri_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yemek_tarif, container, false);
    }

}
