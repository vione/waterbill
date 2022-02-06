package com.example.geektrust.command;

import java.util.List;

public interface ICommand {
    
    public Object execute(List<String> tokeStings);

}
