package com.example.h9fragmentsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;
    SportsFragment sf;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_activity_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try {
            sf = new SportsFragment();
            fm = getSupportFragmentManager();

            fm.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    ft = fm.beginTransaction();
                    int option = result.getInt("SelectedItemIndex");

                    switch (option) {
                        case 0:
                            ft.replace(R.id.ll_bottom, new BadmintonFragment());
                            break;
                        case 1:
                            ft.replace(R.id.ll_bottom, new CricketFragment());
                            break;
                        case 2:
                            ft.replace(R.id.ll_bottom, new TennisFragment());
                            break;
                        case 3:
                            ft.replace(R.id.ll_bottom, new HockeyFragment());
                            break;
                        default:
                            ft.replace(R.id.ll_bottom, new HockeyFragment());
                    }
                    ft.commit();
                }
            });
            ft = fm.beginTransaction();
            ft.add(R.id.ll_top, sf);
            ft.commit();
        }
        catch (Exception ex) {
            Log.d("INITIAL ERROR:->", "onCreate: " + ex.getMessage());
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}