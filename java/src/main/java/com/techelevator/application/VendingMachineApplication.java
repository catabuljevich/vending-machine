package com.techelevator.application;


import com.techelevator.clases.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineApplication {

    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String D = "D";
    private static String FEED_MONEY ="FEED MONEY";
    private static String GIVE_CHANGE ="GIVE CHANGE";


    private Inventory inventory;
    private ShoppingCart itemsSelected;
    private CashRegister cashRegister;
    private Logger register;
    private BigDecimal actualMoney ;
    private BigDecimal[] change = new BigDecimal[3] ;

    public VendingMachineApplication() {
        inventory =  new Inventory();
        itemsSelected = new ShoppingCart();
        cashRegister = new CashRegister();
        actualMoney = BigDecimal.ZERO;
        register = new Logger();
    }


    public boolean addToCart(String idItem, int amount){
        Item itemSelected = null ;
        for (Item item: inventory.getInventory()) {
            if ( idItem.equalsIgnoreCase(item.getId())) {
                itemSelected = item;
            }
        }
        if (itemSelected == null ){
            System.out.println(" ** THE PRODUCT ID DOES NOT EXIST ** ");
            return false;
        }else if(!inventory.removeStock(itemSelected, amount)){
            System.out.println(" ** THE PRODUCT IS SOLD OUT ** ");
            return false;
        }else{
            itemsSelected.addItemToCart(itemSelected, amount);
            return true;
        }



    }

    public boolean isMoneyEnough(BigDecimal moneyFed, BigDecimal moneyOwed) {
        BigDecimal totalCart = BigDecimal.ZERO;

//        for (Item  items: itemsSelected.getCart().keySet()){
//            totalCart = totalCart.add(items.getPrice());
//
//        }
        if (moneyOwed.compareTo(moneyFed) == 0|| moneyOwed.compareTo(moneyFed)== (-1)  ){
            actualMoney = actualMoney.subtract(moneyOwed);
            return true;
        }else {
            System.out.println("** MONEY IS NOT ENOUGH ** ");
            return false;
        }
    }

    public void productDispensed(){
        for (Map.Entry<Item, Integer> items: itemsSelected.getCart().entrySet()){
            Item key = items.getKey();
            System.out.println("Product Dispensed: " + key.getName() );
            System.out.println("Price: $" + key.getPrice());
            System.out.println("Current money: $" + actualMoney);
            System.out.println(key.toString());
        }
    }

    public void createLog(String description, BigDecimal inputMoney, BigDecimal actualMoney){
        Log log = new Log(description,inputMoney,actualMoney);
        register.logMessage(log);
    }


    public void run() {
        boolean executeAplication = true;
        while(executeAplication) {
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
                             try {
                                 BigDecimal feedMoney = BigDecimal.valueOf(Integer.parseInt(UserInput.getFeedMoneyOption()));
                                 actualMoney = actualMoney.add(feedMoney);
                                 createLog(FEED_MONEY, feedMoney,actualMoney);
                                 purchaseMenu();
                                 purchaseChoice =  UserInput.getPurchaseScreenOption(actualMoney);
                             }catch (Exception EX){
                                 System.out.println("Invalid Amount ");
                             }
                         }
                         while (purchaseChoice.equalsIgnoreCase("select")){
                             selectItems();
                             displayItems();
                             String itemId = UserInput.getItemId();
                             //todo agregar al carrito si me alcanza la plata
                             if (isMoneyEnough(actualMoney, inventory.getPrice(itemId) )){
                                 if (addToCart(itemId,1)){
                                     productDispensed();
                                     createLog( inventory.getName(itemId), inventory.getPrice(itemId),actualMoney);
                                 }
                             }
                             purchaseMenu();
                             purchaseChoice =  UserInput.getPurchaseScreenOption(actualMoney);

                         }
                         while (purchaseChoice.equalsIgnoreCase("finish")){
                                finishMenu();
                                createLog(GIVE_CHANGE, actualMoney,BigDecimal.ZERO);
                                change = cashRegister.getChange(actualMoney);
                                displayChange(change);
                                actualMoney = BigDecimal.ZERO;
                                itemsSelected.empty();
                                purchaseChoice = "";

                         }
            } else if(userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application
                executeAplication = false;
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
