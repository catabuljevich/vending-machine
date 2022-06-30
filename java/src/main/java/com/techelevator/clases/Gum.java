package com.techelevator.clases;

public class Gum extends Item {

    public Gum(String id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String toString(){
        return "Chew Chew, Yum!";
    }
}
