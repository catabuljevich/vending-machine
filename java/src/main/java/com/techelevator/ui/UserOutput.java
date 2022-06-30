package com.techelevator.ui;

import com.techelevator.clases.Item;

import java.util.List;
import java.util.Map;

public class UserOutput {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayHomeScreen() {
        clearScreen();
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                                  Home");
        System.out.println("**************************************************************************");
        System.out.println();
    }

    public static void displayInventory(List<Item> items, Map<Item, Integer> stock) {
        clearScreen();
        int stockOfItem = 0;
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                                  Inventory");
        System.out.println("**************************************************************************");
        System.out.println();



        System.out.println("CODE             ITEM         PRICE          AMOUNT AVAILABLE ");
        for(Item item: items)
        {
            if (stock.get(item) >0 ){
                stockOfItem = stock.get(item);
                System.out.println(item.getId() + "          " + item.getName() + "        $" + item.getPrice() + "   " + stockOfItem   );
            }else {
                System.out.println(item.getId() + "          " + item.getName() + "        $" + item.getPrice() + "   " + "SOLD OUT"   );
            }
        }
        System.out.println();

    }

    public static void displayPurchaseMenu(){
        clearScreen();
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                                  Purchase Menu");
        System.out.println("**************************************************************************");
        System.out.println();

    }

    public static void displayFeedMoney(){
        clearScreen();
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                                  FEED MONEY");
        System.out.println("**************************************************************************");
        System.out.println();

    }


    public static void displaySelectItems() {
        clearScreen();
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                                  SELECT PRODUCT");
        System.out.println();
    }
}
