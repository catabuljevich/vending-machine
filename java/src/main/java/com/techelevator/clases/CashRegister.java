package com.techelevator.clases;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashRegister {

    private static BigDecimal quarter  = BigDecimal.valueOf(0.25);
    private static BigDecimal dime  = BigDecimal.valueOf(0.10);
    private static BigDecimal nickel  = BigDecimal.valueOf(0.05);

    public  BigDecimal[] getChange(BigDecimal actualMoney) {
        BigDecimal[] change = new BigDecimal[3];
        BigDecimal howManyQuarters = BigDecimal.ZERO;
        BigDecimal howManyDimes = BigDecimal.ZERO;
        BigDecimal howManyNickels = BigDecimal.ZERO;
        if (actualMoney.remainder(quarter) == BigDecimal.ZERO  ) {
              howManyQuarters = actualMoney.divide(quarter);
              change[0] = howManyQuarters;
        } else {
            howManyQuarters = actualMoney.divide(quarter).setScale(0, RoundingMode.FLOOR);
            actualMoney = actualMoney.subtract(howManyQuarters.multiply(quarter));
            change[0] = howManyQuarters;
            if (actualMoney.remainder(dime) == BigDecimal.ZERO) {
                howManyDimes = actualMoney.divide(dime);
                change[1] = howManyDimes;
            }else {
                howManyDimes = actualMoney.divide(dime).setScale(0, RoundingMode.FLOOR);
                actualMoney = actualMoney.subtract(howManyDimes.multiply(dime));
                howManyNickels = actualMoney.divide(nickel);
                change[1] = howManyDimes;
                change[2] = howManyNickels;
            }
        }
        return change;
    }
}
