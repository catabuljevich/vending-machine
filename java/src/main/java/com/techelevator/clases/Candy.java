package com.techelevator.clases;

import java.math.BigDecimal;

public class Candy extends Item {

    public static  String LETTER_ID= "B";
    public Candy(String id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String getId(){
        super.setId(LETTER_ID + getId());
        return super.getId();
    }

    @Override
    public String toString(){
        return "Munch, Munch, Yum!";
    }
}
