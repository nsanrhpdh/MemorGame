package com.annisa.memorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView lv1,lv2,lv3;
    ImageView home,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        lv1 = (TextView) findViewById(R.id.lv1);
        lv2 = (TextView) findViewById(R.id.lv2);
        lv3 = (TextView) findViewById(R.id.lv3);
        home = (ImageView) findViewById(R.id.home);
        about = (ImageView) findViewById(R.id.about);

        lv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,MainActivity3.class);
                startActivity(i);
                finish();
            }
        });

        lv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

        lv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,pilih.class);
                startActivity(i);
                finish();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,NisaActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}