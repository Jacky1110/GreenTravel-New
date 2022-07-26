package com.jotangi.greentravel.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jotangi.greentravel.R;
import com.jotangi.greentravel.ui.storeManager.StoreManagerFragment;
import com.jotangi.greentravel.ui.account.AccountLoginFragment;

public class LoginMain extends AppCompatActivity {

    private String TAG = getClass().getSimpleName() + "(TAG)";

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        initData();
        init();
        initHandler();
    }


    private void initData() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.framelayout, new AccountLoginFragment());
        transaction.commit();

    }


    private void init(){
        tabLayout = findViewById(R.id.tab);

    }

    private void initHandler() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentChange(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    private void fragmentChange(int position) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (0 == position) {
            transaction.replace(R.id.framelayout, new AccountLoginFragment());
        } else {
            transaction.replace(R.id.framelayout, new StoreManagerFragment());
        }
        transaction.commit();
    }
}