package com.example.h9sqliteapp;

public class Student {
    private int roll;
    private String name;
    private float average;
    private String grade;
    public Student(int roll,String name, float average, String grade){
        this.name = name;
        this.roll = roll;
        this.average = average;
        this.grade = grade;
    }
    public int getRoll(){
        return roll;
    }

    public float getAverage() {
        return average;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}

