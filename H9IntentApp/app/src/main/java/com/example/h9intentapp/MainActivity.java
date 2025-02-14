package com.example.h9intentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
        public void show_act(View v){
            Intent i = new Intent(this, AnotherActivity.class);
            startActivity(i);
        }

        public void show_url(View v) {
            String url = "https://www.geeksforgeeks.org/what-is-intent-in-android/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        public void show_email(View v) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("mailto: "));
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_EMAIL, "");
            i.putExtra(Intent.EXTRA_CC, "");
            i.putExtra(Intent.EXTRA_SUBJECT, "Your subject ");
            i.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
            try{
                startActivity(Intent.createChooser(i, "Send mail..."));
                finish();
                Log.i("Finished sending email.", "");
            }
            catch(android.content.ActivityNotFoundException ex){
                Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }
        public void show_call(View v) {
            String phnNo = "9951809424";
            Intent i = new Intent (Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+phnNo));
            if(i.resolveActivity(getPackageManager()) != null)
                startActivity(i);
        }
}