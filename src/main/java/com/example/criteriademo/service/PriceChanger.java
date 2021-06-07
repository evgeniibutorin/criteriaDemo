package com.example.criteriademo.service;

import com.example.criteriademo.model.Price;

public class PriceChanger {

    public PriceChanger(Price price, Pluser pluser) {
        this.price = price;
        this.pluser = pluser;
    }

    private final Price price;
    private final Pluser pluser;

    int x;

    public void pluser() {
        this.x++;
    }

    public void changePrice(int tax) {
        if (tax > 30) {
            for (int i = 0; i < tax; i++) {
                x = pluser.pluser(i);
            }
        } else {
            x = tax;
        }
        price.setPrice(x);
    }
}
