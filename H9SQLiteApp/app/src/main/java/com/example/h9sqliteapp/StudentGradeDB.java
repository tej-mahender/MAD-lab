package com.example.h9sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentGradeDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students";
    private static final String TABLE_NAME = "StudentGrade";
    private static final String KEY_ID = "Roll";
    private static final String KEY_NAME = "name";
    private static final String KEY_AVG = "average";
    private static final String KEY_GRADE = "grade";

    public StudentGradeDB(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Students_TABLE ="CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT, "
                + KEY_AVG + " FLOAT, "
                + KEY_GRADE + " TEXT " + " )";
        db.execSQL(CREATE_Students_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_ID,student.getRoll());
        values.put(KEY_GRADE,student.getGrade());
        values.put(KEY_AVG, student.getAverage());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    String getStudent(int roll){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("StudentGrade",new String[]{"Roll","name","average","grade"},
                "Roll=?",new String[]{Integer.toString(roll)},null,null,null);
        if(c.moveToFirst()) {
            int r = c.getInt(0);
            String name = c.getString(1);
            float avg = c.getFloat(2);
            String grade = c.getString(3);
            String print = "Roll=" + r + "\nName=" + name + "\nAverage=" +avg+"\nGrade="+grade;
            return print;
        }
        else{
            return "No record found";
        }
    }
    void deleteStudent(int roll) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("StudentGrade","Roll=?",new String[]{Integer.toString(roll)});
        db.close();
    }

    void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_ID,student.getRoll());
        values.put(KEY_GRADE,student.getGrade());
        values.put(KEY_AVG, student.getAverage());

        db.update(TABLE_NAME,values,"Roll=?",new String[]{Integer.toString(student.getRoll())});
        db.close();
    }
}
