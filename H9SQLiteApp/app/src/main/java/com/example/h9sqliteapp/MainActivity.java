package com.example.h9sqliteapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    StudentGradeDB sgdb;
    Student s;
    EditText edttxt_roll, edttxt_name, edttxt_avg, edttxt_grade;
    int roll;
    String sname,grade;
    float avg;

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

        sgdb = new StudentGradeDB(getApplicationContext());
        edttxt_roll = findViewById(R.id.edttxt_roll);
        edttxt_name = findViewById(R.id.edttxt_name);
        edttxt_avg = findViewById(R.id.edttxt_avg);
        edttxt_grade = findViewById(R.id.edttxt_grade);
    }
    public void insertStudent(View v){
        roll = Integer.parseInt(edttxt_roll.getText().toString());
        sname = edttxt_name.getText().toString();
        avg = Float.parseFloat(edttxt_avg.getText().toString());
        grade = edttxt_grade.getText().toString();
        s = new Student(roll, sname, avg, grade);
        sgdb.addStudent(s);
        Toast.makeText(this,"Insertion Successful",Toast.LENGTH_LONG).show();
    }

    public void deleteStudent(View v){
        try{
            roll = Integer.parseInt(edttxt_roll.getText().toString());
            sgdb.deleteStudent(roll);
            Toast.makeText(this,"Deletion Successful",Toast.LENGTH_LONG).show();
            Log.d("H9 Good","delete: Successful");
        }
        catch(Exception e){
            Log.d("H9 Problem","Delete: Unsuccessful"+e.getMessage());
        }
    }

    public void getStudent(View v){
        try{
            roll = Integer.parseInt(edttxt_roll.getText().toString());
            String c = sgdb.getStudent(roll);
            Toast.makeText(this,c,Toast.LENGTH_LONG).show();
            Log.d("H9 Good","Get Student: Successful" + c);
        }
        catch(Exception e){
            Log.d("H9 Problem","Get: Unsuccessful"+e.getMessage());
        }
    }

    public void updateStudent(View v){
        try{
        roll = Integer.parseInt(edttxt_roll.getText().toString());
        sname = edttxt_name.getText().toString();
        avg = Float.parseFloat(edttxt_avg.getText().toString());
        grade = edttxt_grade.getText().toString();
        s = new Student(roll, sname, avg, grade);
        sgdb.updateStudent(s);
        Toast.makeText(this,"Updation Successful",Toast.LENGTH_LONG).show();
        Log.d("H9 Good","Update Student: Successful");
        }
        catch(Exception e){
            Log.d("H9 Problem","Update: Unsuccessful"+e.getMessage());
        }
    }
}