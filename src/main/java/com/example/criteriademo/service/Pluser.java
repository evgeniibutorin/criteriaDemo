package com.example.criteriademo.service;

public class Pluser {

    int l = 0;

    public void pl(){
        l++;
    }

    public int pluser(int x) {
        this.l=x;
        pl();
        return l;
    }
}
