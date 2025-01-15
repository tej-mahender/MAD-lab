package com.example.h9dialogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show_dialog(View v){
        Log.d("My Dialog", "show_dialog: one");
        AlertDialog.Builder abd = new AlertDialog.Builder(this);
        Log.d("my Diallog", "show_dialog: two");
        Toast.makeText(this, "Hii", Toast.LENGTH_SHORT).show();
        abd.setTitle("My Dialog");
        abd.setMessage("This is the Dailog created");
        abd.setCancelable(true);
        abd.setPositiveButton("Its OKK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "clicked on Its OKK", Toast.LENGTH_SHORT).show();
            }
        });
        abd.setNegativeButton("Oh NO!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "clicked on NOO", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog ad = abd.create();
        Log.d("My Dialog", "show_dialog: three"+ad.toString());
        ad.show();
    }
    public void show_date(View v){
        Calendar c = Calendar.getInstance();
        int dY = c.get(Calendar.YEAR);
        int dM = c.get(Calendar.MONTH);
        int dD = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this,i+"Y:,"+i1+"M:,"+i2+"D",Toast.LENGTH_SHORT).show();
            }
        },dY,dM,dD);
        dpd.setTitle("Pick a date");
        dpd.show();
    }
    public void show_time(View v){
        Calendar c= Calendar.getInstance();
        int dh = c.get(Calendar.HOUR);
        int dm = c.get(Calendar.MINUTE);
        TimePickerDialog tdp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i+"H:,"+i1+"M:", Toast.LENGTH_SHORT).show();
            }
        },dh,dm,true);
        tdp.setTitle("Pick a Time");
        tdp.show();
    }
}