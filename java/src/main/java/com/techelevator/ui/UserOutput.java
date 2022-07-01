package com.techelevator.ui;

import com.techelevator.clases.Item;

import java.math.BigDecimal;
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


        String heder1 ="CODE";
        String heder2 ="ITEM";
        String heder3 ="PRICE";
        String heder4 ="AMOUNT AVAILABLE";
        String totalHeader= String.format(heder1 + " %10s",heder2  + " %10s",heder3) ;
        System.out.println(totalHeader);

        //System.out.println("CODE             ITEM         PRICE          AMOUNT AVAILABLE ");
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

    public static void displayFinishMenu() {
        clearScreen();
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                                  FINISH TRANSACTION");
        System.out.println();
    }

    public static void displayChange(BigDecimal[] change) {
        BigDecimal quorters = change[0];
        BigDecimal dimes = change[1];
        BigDecimal nickels = change[2];
        System.out.println("Your change is :");
        if (dimes == null) {
            System.out.println( quorters +" quarters");
        } else if (nickels == null) {
            System.out.println( quorters +" quarters");
            System.out.println( dimes +" dimes ");
        }else {
            System.out.println(quorters + " quarters");
            System.out.println(dimes + " dimes ");
            System.out.println(nickels + " nickels ");
        }

    }
}
