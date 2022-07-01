package com.techelevator.application;


import com.techelevator.clases.CashRegister;
import com.techelevator.clases.Inventory;
import com.techelevator.clases.Item;
import com.techelevator.clases.ShoppingCart;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineApplication {

    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String D = "D";

    private Inventory inventory;
    private ShoppingCart itemsSelected;
    private CashRegister cashRegister;
    private BigDecimal actualMoney ;
    private BigDecimal[] change = new BigDecimal[3] ;

    public VendingMachineApplication() {
        inventory =  new Inventory();
        itemsSelected = new ShoppingCart();
        cashRegister = new CashRegister();
        actualMoney = BigDecimal.ZERO;
    }


    public boolean addToCart(String idItem, int amount){
        Item itemSelected = null ;
        for (Item item: inventory.getInventory()) {
            if ( idItem.equalsIgnoreCase(item.getId())) {
                itemSelected = item;
            }
        }
        if (itemSelected == null || (!inventory.removeStock(itemSelected, amount))){
            return false;
        }else {
            itemsSelected.addItemToCart(itemSelected, amount);
            return true;
        }

    }

    public boolean isMoneyEnough(BigDecimal moneyFed) {
        BigDecimal totalCart = BigDecimal.ZERO;
        for (Map.Entry<Item, Integer> items: itemsSelected.getCart().entrySet()){
            Item key = items.getKey();
            totalCart = totalCart.add(key.getPrice());

        }
        if (totalCart.compareTo(moneyFed) == 0|| totalCart.compareTo(moneyFed)== (-1)  ){
            actualMoney = actualMoney.subtract(totalCart);
            return true;
        }else {
            return false;
        }
    }

    public void productDispensed(){
        for (Map.Entry<Item, Integer> items: itemsSelected.getCart().entrySet()){
            Item key = items.getKey();
            System.out.println(key.toString());

        }
    }


    public void run() {
        while(true) {
            // todo: display home screen
            UserOutput.displayHomeScreen();

            // todo: and get user choice
            String userChoice =  UserInput.getHomeScreenOption();

            if(userChoice.equalsIgnoreCase("display")) {
                // todo: logic to display all vending machine items
                displayItems();

            } else if(userChoice.equalsIgnoreCase("purchase")) {
                // todo: logic to display purchase options
                purchaseMenu();
                String purchaseChoice =  UserInput.getPurchaseScreenOption(actualMoney );
                         while (purchaseChoice.equalsIgnoreCase("feed")){
                             feedMoney();
                             BigDecimal feedMoney = BigDecimal.valueOf(Integer.parseInt(UserInput.getFeedMoneyOption()));
                             actualMoney = actualMoney.add(feedMoney);
                             purchaseMenu();
                             purchaseChoice =  UserInput.getPurchaseScreenOption(actualMoney);
                         }
                         while (purchaseChoice.equalsIgnoreCase("select")){
                             selectItems();
                             displayItems();
                             String itemId = UserInput.getItemId();
                             //todo agregar al carrito si me alcanza la plata
                             if (!addToCart(itemId,1)){
                                 purchaseMenu();
                                 purchaseChoice =  UserInput.getPurchaseScreenOption(actualMoney);
                             } else if (addToCart(itemId,1) && isMoneyEnough(actualMoney) ) {
                                // addToCart(itemId,1);
                                 productDispensed();
                                 purchaseMenu();
                                 purchaseChoice =  UserInput.getPurchaseScreenOption(actualMoney);
                             }
                         }
                         while (purchaseChoice.equalsIgnoreCase("finish")){
                                finishMenu();
                                change = cashRegister.getChange(actualMoney);
                                displayChange(change);
                                actualMoney = BigDecimal.ZERO;
                                itemsSelected.empty();
                                purchaseChoice = "";

                         }
            } else if(userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application

                break;
            }
        }
    }

    private void displayChange(BigDecimal[] change) {
        UserOutput.displayChange( change);
    }

    private void finishMenu() {
        UserOutput.displayFinishMenu();
    }

    public void displayItems(){
         UserOutput.displayInventory(inventory.getInventory(), inventory.getStock());
    }

    public void purchaseMenu(){
        UserOutput.displayPurchaseMenu();
    }

    public void feedMoney(){
        UserOutput.displayFeedMoney();
    }

    public void selectItems(){
        UserOutput.displaySelectItems();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ShoppingCart getItemsSelected() {
        return itemsSelected;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }
}
