package com.example.movers_app;

import android.widget.Spinner;

public class User {
    public String name, email, spinner;

    public User(){

    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public User(String name, String email, Spinner spinner) {
        this.email = email;
        this.name = name;
        this.getSpinner();
    }

}
