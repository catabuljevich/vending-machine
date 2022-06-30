package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase ");
        System.out.println("(3) Exit");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if(option.equals("1"))
        {
            return "display";
        }
        else if(option.equals("2"))
        {
            return "purchase";
        }
        else if(option.equals("3"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }


    public static String getPurchaseScreenOption(BigDecimal fedMoney){
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: "+  fedMoney);

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if(option.equals("1"))
        {
            return "feed";
        }
        else if(option.equals("2"))
        {
            return "select";
        }
        else if(option.equals("3"))
        {
            return "finish";
        }
        else
        {
            return "";
        }

    }

    public static String getFeedMoneyOption() {
        System.out.println("Insert the amount of money (whole dollar amounts) :");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        return selectedOption;
    }

    public static String getItemId() {

        System.out.println("Insert the code of the product you want to purchase: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        return selectedOption;

    }
}
