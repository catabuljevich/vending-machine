package com.techelevator.clases;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String toString(){
        return "Munch, Munch, Yum!";
    }
}
