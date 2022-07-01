package com.techelevator.clases;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map <Item, Integer> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addItemToCart(Item item, int amount){
//        if (cart.containsKey(item)) {
//            cart.put(item, cart.get(item) + amount);
//        }else{
            cart.put(item,amount);
//        }
    }

    public void empty(){
        cart = new HashMap<>();
    }


    public Map<Item, Integer> getCart() {
        return cart;
    }
}
