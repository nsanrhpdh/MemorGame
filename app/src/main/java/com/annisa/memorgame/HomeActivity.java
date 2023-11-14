package com.annisa.memorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loading = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(loading);
                finish();
            }
        },2000);
    }
}