package com.murat.gky401.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.murat.gky401.R;


public class VKI_fragment extends Fragment implements View.OnClickListener {

    EditText etBoy, etKilo;
    Button btnHesapla;
    TextView tvSonuc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vki__home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etBoy = view.findViewById(R.id.etBoy);
        etKilo = view.findViewById(R.id.etKilo);
        btnHesapla = view.findViewById(R.id.btnHesapla);
        tvSonuc = view.findViewById(R.id.tvSonuc);

        btnHesapla.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHesapla:
                hesapla();
                break;
        }
    }


    float boy, kilo;
    private void hesapla() {

            String s_boy, s_kilo;

            try {
                s_boy = etBoy.getText().toString();
                s_kilo = etKilo.getText().toString();
                if (!s_boy.equals("") && !s_kilo.equals("")) {
                    boy = Float.parseFloat(etBoy.getText().toString());
                    kilo = Float.parseFloat(etKilo.getText().toString());
                } else {
                    Toast.makeText(getActivity(), "lütfen değerlerini giriniz", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            float _boy = boy/100;
            float sonuc = kilo / (_boy*_boy);
            sonuc = ((int) sonuc);
            tvSonuc.setText("VKI Sonucunuz : "+ sonuc);

    }
}
