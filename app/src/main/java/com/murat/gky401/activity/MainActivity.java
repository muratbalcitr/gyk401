package com.murat.gky401.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.murat.gky401.R;
import com.murat.gky401.fragment.Yemek_Tarifleri_fragment;
import com.murat.gky401.fragment.VKI_fragment;
import com.murat.gky401.fragment.Yemek_Listesi_fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    ActionBar toolbar;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();

        if (toolbar != null) {
            toolbar.setTitle("VKI hesaplama");
            fragment = new VKI_fragment();
            loadFragment(fragment);
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_vki:
                if (toolbar != null) {
                    toolbar.setTitle("VKI hesaplama");
                }
                fragment = new VKI_fragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_yemek_listesi:
                if (toolbar != null) {
                    toolbar.setTitle("Yemek Listesi");
                }
                fragment = new Yemek_Listesi_fragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_yemek_tarifleri:
                if (toolbar != null) {
                    toolbar.setTitle("Yemek Tarifleri");
                }
                fragment = new Yemek_Tarifleri_fragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    }
}
