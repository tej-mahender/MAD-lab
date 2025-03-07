package com.example.h9firebaseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText edtxtroll, edtxtname, edtxtavg, edtxtgrade;
    FirebaseDatabase fdb;
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
        edtxtroll = (EditText)this.findViewById(R.id.rollEdt);
        edtxtavg = (EditText) this.findViewById(R.id.avgEdt);
        edtxtname = (EditText) this.findViewById(R.id.nameEdt);
        edtxtgrade = (EditText) this.findViewById(R.id.graEdt);
        fdb = FirebaseDatabase.getInstance();
    }
    public void insertStudent(View v){
        Student s = new Student(edtxtroll.getText().toString(),edtxtname.getText().toString(), edtxtgrade.getText().toString(),edtxtavg.getText().toString());
        fdb.getReference("students").push().setValue(s)
                .addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void unused){
                        Toast.makeText(MainActivity.this,"Insertion Success",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Insertion Failure" + e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void getStudent(View v) {
        fdb.getReference("students").get()
                .addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                Student s = data.getValue(Student.class);
                                if (s != null) {
                                    Toast.makeText(MainActivity.this, "Name: " + s.getName() + ", Roll: " + s.getRoll(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                            else{
                                Toast.makeText(MainActivity.this,"No data Found", Toast.LENGTH_LONG).show();
                            }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Retrivel Failure" + e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}