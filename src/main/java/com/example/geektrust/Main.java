package com.example.geektrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.geektrust.command.CommandExecutor;
import com.example.geektrust.config.ApplicationConfiguration;

public class Main {

    public static void run(List<String> commandLineArgs){
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        CommandExecutor commandExecutor = applicationConfiguration.getCommandExecutor();
        File inputFile = new File(commandLineArgs.get(0).split("=")[1]);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine().strip();
            while(line != null){
                commandExecutor.runCommand(new ArrayList<>(Arrays.asList(line.split(" "))));
                line = reader.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args)  {

        //Here we are taking input from the command line which explains what the file is
        //And the locatin
        //ex = INPUT=sample_input/input1.txt"
        String expectedOrder = "INPUT";
        List<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));
        String actualOrder = commandLineArgs.stream().map(arg -> arg.split("=")[0])
            .collect(Collectors.joining());
        if(actualOrder.equals(expectedOrder)) run(commandLineArgs);
        else System.out.println("Not matching argunments");
	}
}
