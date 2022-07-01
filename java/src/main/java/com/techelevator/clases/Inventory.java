package com.techelevator.clases;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {
    Scanner input = new Scanner(System.in);
    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String D = "D";
    private static int MAX_STOCK = 5;

    private List <Item> inventory;
    private Map<Item, Integer> stock;

    public Inventory() {
        this.inventory = addItems();
        this.stock = renewStock();
    }
    private Map <Item, Integer> renewStock(){
        Map <Item, Integer> stock = new HashMap<>();
        for (Item item: inventory) {
            stock.put(item, MAX_STOCK);
        }
        return stock;
    }
    public List<Item> getInventory() {
        return inventory;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    private List<Item> addItems () {
        List<Item> items = new ArrayList<>();
        File file = new File("vendingmachine.csv");

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String item = reader.nextLine();
                String[] column = item.split("\\|");
                if (column[0].startsWith("A")) {
                    Chips chips = new Chips(column[0], column[1], column[2]);
                    items.add(chips);
                } else if (column[0].startsWith("B")) {
                    Candy candy = new Candy(column[0], column[1], column[2]);
                    items.add(candy);
                } else if (column[0].startsWith("C")) {
                    Beverage beverage = new Beverage(column[0], column[1], column[2]);
                    items.add(beverage);
                } else if (column[0].startsWith("D")) {
                    Gum gum = new Gum(column[0], column[1], column[2]);
                    items.add(gum);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return items;
    }
    public boolean removeStock (Item item, int amount){
        if (stock.containsKey(item)) {
            if (stock.get(item) <= MAX_STOCK && stock.get(item)-amount >= 0 ) {
                stock.put(item, (stock.get(item) - amount));
                return true;
            }
        }
        return false;
    }

    public BigDecimal getPrice(String itemId){
        BigDecimal price = BigDecimal.ZERO;
        for(Item item : inventory){
            if (item.getId().equals(itemId.toUpperCase())) {
                price = item.getPrice();
            }
        }
        return price;
    }
}
