package com.example.h9firebaseapp;

public class Student {
    private String roll, name, grade, avg;

    // Default constructor required for Firebase
    public Student() {}

    public Student(String roll, String name, String grade, String avg) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
        this.avg = avg;
    }

    public String getRoll() { return roll; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public String getAvg() { return avg; }

    public void setRoll(String roll) { this.roll = roll; }
    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setAvg(String avg) { this.avg = avg; }
}
