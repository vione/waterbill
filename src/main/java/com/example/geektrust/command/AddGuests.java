package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.service.AllotmentService;

public class AddGuests implements ICommand{

    private AllotmentService allotmentService;

    public AddGuests(AllotmentService allotmentService){
        this.allotmentService = allotmentService;
    }
    @Override
    public Object execute(List<String> tokeStings) {
        allotmentService.addGuests(Integer.parseInt(tokeStings.get(1)));
        return null;
    }
    
}
