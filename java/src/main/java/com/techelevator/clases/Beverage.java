package com.techelevator.clases;

public class Beverage extends Item {

        public static  String LETTER_ID= "C";
        public Beverage(String id, String name, String price) {
            super(id, name, price);
        }

        @Override
        public String getId(){
            super.setId(LETTER_ID + getId());
            return super.getId();
        }

        @Override
        public String toString(){
            return "Glug Glug , Yum";
        }

}
