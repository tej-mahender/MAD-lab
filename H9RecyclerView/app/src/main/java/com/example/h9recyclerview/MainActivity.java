package com.example.h9recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
        List<Department> depts;
        depts = new ArrayList<>();
        depts.add(new Department(R.drawable.cse,"CSE","116" ));
        depts.add(new Department(R.drawable.ece,"ECE","100" ));
        depts.add(new Department(R.drawable.mech,"MECH","40" ));
        RecyclerView rcv = (RecyclerView) this.findViewById(R.id.rcv);
        rcv.setAdapter(new DepartmentAdapter(getApplicationContext(), depts));
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}