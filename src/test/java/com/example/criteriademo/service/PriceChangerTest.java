package com.example.criteriademo.service;

import com.example.criteriademo.model.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PriceChangerTest {

    private Price price;
    Pluser pluser;
    PriceChanger priceChanger;
    @Test
    public void changePrice() {
        price = new Price();
        pluser = mock(Pluser.class);
        priceChanger  = new PriceChanger(price,pluser);
        priceChanger.changePrice(100);
        priceChanger.changePrice(100);
        verify(pluser,atLeast(2)).pluser(99);
    }

}