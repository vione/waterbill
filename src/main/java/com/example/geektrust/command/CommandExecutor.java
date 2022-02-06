package com.example.geektrust.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {
    
    private Map<String, ICommand> commandMap = new HashMap<>();

    public void register(String commandName, ICommand command){
        commandMap.put(commandName, command);
    }

    public Object runCommand(List<String> tokens){
        ICommand command = commandMap.get(tokens.get(0));
        if(command == null) {
            System.out.println("Command not found");
            return null;
        } else{
            return command.execute(tokens);
        }
    }
}
