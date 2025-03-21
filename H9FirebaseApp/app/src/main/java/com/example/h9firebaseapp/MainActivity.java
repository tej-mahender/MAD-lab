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
    DatabaseReference studentRef;

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

        edtxtroll = findViewById(R.id.rollEdt);
        edtxtavg = findViewById(R.id.avgEdt);
        edtxtname = findViewById(R.id.nameEdt);
        edtxtgrade = findViewById(R.id.graEdt);

        fdb = FirebaseDatabase.getInstance();
        studentRef = fdb.getReference("students");
    }

    public void insertStudent(View v) {
        String roll = edtxtroll.getText().toString();
        Student s = new Student(roll, edtxtname.getText().toString(), edtxtgrade.getText().toString(), edtxtavg.getText().toString());

        studentRef.child(roll).setValue(s)
                .addOnSuccessListener(unused -> Toast.makeText(MainActivity.this, "Insertion Successful", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Insertion Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    public void getStudent(View v) {
        String roll = edtxtroll.getText().toString();

        studentRef.child(roll).get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        Student s = dataSnapshot.getValue(Student.class);
                        if (s != null) {
                            Toast.makeText(MainActivity.this, "Rollno: "+s.getRoll()+"\nName: " + s.getName(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "No student found with Roll No: " + roll, Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Retrieval Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    public void updateStudent(View v) {
        String roll = edtxtroll.getText().toString();
        String name = edtxtname.getText().toString();
        String avg = edtxtavg.getText().toString();
        String grade = edtxtgrade.getText().toString();

        Student updatedStudent = new Student(roll, name, grade, avg);

        studentRef.child(roll).setValue(updatedStudent)
                .addOnSuccessListener(unused -> Toast.makeText(MainActivity.this, "Update Successful", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Update Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    public void deleteStudent(View v) {
        String roll = edtxtroll.getText().toString();

        studentRef.child(roll).removeValue()
                .addOnSuccessListener(unused -> Toast.makeText(MainActivity.this, "Deletion Successful", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Deletion Failure: " + e.getMessage(), Toast.LENGTH_LONG).show());
    }
}
