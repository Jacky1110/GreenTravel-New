package com.jotangi.greentravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class WelcomeActivity extends AppCompatActivity {

    public static Uri uri;
    public static String storeID;
    public static String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorDarkToast));
        handler.postDelayed(runnable, 1250);

        uri = getIntent().getData();
        Log.d("豪豪", "onCreate: " + uri);

//        if (uri != null)
//        {
//
//            String str = uri.getHost();
//            String[] tokens = str.split("=|&");
//            storeID = tokens[1];
//            type = tokens[3];
//            Log.d("豪豪", "onCreate: " + storeID + type);
//        }
        Intent intent = getIntent();
        String date = intent.getDataString();
        Log.d("TAG", "date: " + date);
    }

    Handler handler = new Handler();
    Runnable runnable = () ->
    {
        startActivity(new Intent(this, LoginMainActivity.class));
        finish();
    };
}