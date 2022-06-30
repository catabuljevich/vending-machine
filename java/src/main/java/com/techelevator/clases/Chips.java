package com.techelevator.clases;

public class Chips extends Item {


    public Chips(String id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String toString(){

        return "Crunch Crunch, Yum!";
    }
}
