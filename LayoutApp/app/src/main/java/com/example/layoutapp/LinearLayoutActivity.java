package com.example.layoutapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear_layout);
        ImageView imgv1 = (ImageView)this.findViewById(R.id.img1);
        imgv1.setImageResource(R.drawable.pic1);
        ImageView imgv2=(ImageView)this.findViewById(R.id.img2);
        imgv2.setImageResource(R.drawable.pic2);
    }
    public void changeOrientration(View v){
        LinearLayout ll = findViewById(R.id.linear);
        if(ll.getOrientation()==LinearLayout.HORIZONTAL){
            ll.setOrientation(LinearLayout.VERTICAL);
        }
        else {
            ll.setOrientation(LinearLayout.HORIZONTAL);
        }
    }
}