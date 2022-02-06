package com.example.geektrust;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Integration test")
public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Testing for 2BHK, Should Print Expected Bill")
    public void getBill_2BHKtest(){

        //Arrange
        String expected = "2400 5215";
        List<String> args = new ArrayList<>(List.of("INPUT=sample_input/input1.txt"));

        //Act
        Main.run(args);

        //Assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString().strip());
    }

    @Test
    @DisplayName("Testing for 3BHK, Should Print Expected Bill")
    public void getBill_3BHKtest(){

        //Arrange
        String expected = "3000 5750";
        List<String> args = new ArrayList<>(List.of("INPUT=sample_input/input2.txt"));

        //Act
        Main.run(args);

        //Assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString().strip());

    }
}