package com.techelevator.clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logger {

    List<Log> logs = new ArrayList<>();


    public void logMessage(Log log){

        Scanner input = new Scanner(System.in);

        String fileName;
        File logFile;

        fileName = (".log.txt");
        logFile = new File(fileName);

        try(FileOutputStream outputStream = new FileOutputStream(logFile, true);
            PrintWriter destination = new PrintWriter(outputStream);)
        {
            String date = log.getToday().toString();
            String description = log.getDescription();
            String inputMonet = log.getMoneyEntered().toString();
            String balance = log.getBalance().toString();

            //String line = String.format("%s %s %s %s", date, description,inputMonet,balance);
            destination.println(date + " " + description + ": $" + inputMonet + " $" + balance);
        }
        catch(Exception ex)
        {
            //swallow
        }

    }

    public List<Log> getLogs() {
        return logs;
    }
}
