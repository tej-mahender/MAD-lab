package com.example.layoutapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table);
        ImageView imgv1=(ImageView)this.findViewById(R.id.img1);
        imgv1.setImageResource(R.drawable.pic1);
        ImageView imgv2=(ImageView)this.findViewById(R.id.img2);
        imgv2.setImageResource(R.drawable.pic2);
    }
}