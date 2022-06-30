package com.techelevator.clases;

public class Chips extends Item {

    public static  String LETTER_ID= "A";
    public Chips(String id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String getId(){
        super.setId(LETTER_ID + getId());
        return super.getId();
    }

    @Override
    public String toString(){
        return "Chew Chew, Yum!";
    }
}
