package com.techelevator.clases;

public class Beverage extends Item {

        public Beverage(String id, String name, String price) {
            super(id, name, price);
        }

        @Override
        public String toString(){
            return "Glug Glug , Yum";
        }

}
