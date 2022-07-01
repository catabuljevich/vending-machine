package com.techelevator.clases;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Log {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";
    private String today;
    private String description;
    private BigDecimal moneyEntered;
    private BigDecimal balance;

    public Log(String description, BigDecimal moneyEntered, BigDecimal balance) {
        today = setLocalDateTime();
        this.description = description;
        this.moneyEntered = moneyEntered;
        this.balance = balance;
    }

    private String setLocalDateTime() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = today.format(formatter);
        return formatDateTime;
    }





    public String getToday() {
        return today;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMoneyEntered() {
        return moneyEntered;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
