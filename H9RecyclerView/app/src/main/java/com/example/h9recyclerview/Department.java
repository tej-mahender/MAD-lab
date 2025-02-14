package com.example.h9recyclerview;

public class Department {
    int dpic;
    String dname;
    String dseats;

    public Department(int dpic, String dname, String dseats) {
        this.dpic = dpic;
        this.dname = dname;
        this.dseats = dseats;
    }

    public int getDpic() {
        return dpic;
    }

    public void setDpic(int dpic) {
        this.dpic = dpic;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDseats() {
        return dseats;
    }

    public void setDseats(String dseats) {
        this.dseats = dseats;
    }
}
