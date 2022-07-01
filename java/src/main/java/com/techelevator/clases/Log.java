package com.techelevator.clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Log {

    private LocalDateTime today;
    private String description;
    private BigDecimal moneyEntered;
    private BigDecimal balance;

    public Log(String description, BigDecimal moneyEntered, BigDecimal balance) {
        today = LocalDateTime.now();
        this.description = description;
        this.moneyEntered = moneyEntered;
        this.balance = balance;
    }


    public void logMessage(){
        String logFilePath = (".log.txt");
        File logFile = new File(logFilePath);
        try(FileOutputStream outputStream = new FileOutputStream(logFile, true);
            PrintWriter writer = new PrintWriter(outputStream);)
        {
           // String line = String.format("%s %s", currentTime, message);
           // writer.println(line);
        }
        catch(Exception ex)
        {
            //swallow
        }

    }


    public LocalDateTime getToday() {
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
