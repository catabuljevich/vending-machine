package com.techelevator.clases;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test
    public void toSting_CorrectAnswer() {

        // arrange - setup
        String id = "A1";
        String name = "SuperChips";
        String price = "2.5";
        Chips chips = new Chips(id, name,price);
        String expected = "Crunch Crunch, Yum!";
        // act - the ONE function that you are testing
        String actual= chips.toString();
        //
        String message = "Because CHIPS  should always return Crunch Crunch, Yum! .";
        assertEquals(message, expected, actual);

    }

}
