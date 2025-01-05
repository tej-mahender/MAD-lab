package com.example.layoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void show_linear_activity(View v){
        Intent i = new Intent(this,LinearLayoutActivity.class);
        this.startActivity(i);
    }
    public void show_table_activity(View v){
        Intent i = new Intent(this,TableActivity.class);
        this.startActivity(i);
    }
    public void show_relative_activity(View v){
        Intent i = new Intent(this, RelativeActivity.class);
        this.startActivity(i);
    }
    public void show_frame_activity(View v){
        Intent i = new Intent(this, FrameActivity.class);
        this.startActivity(i);
    }
    public void show_tab_activity(View v){
        Intent i = new Intent(this, TabActivity.class);
        this.startActivity(i);
    }

}