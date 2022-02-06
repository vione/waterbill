package com.example.geektrust.command;

import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.service.AllotmentService;

public class AllotWaterCommand  implements ICommand {

    private AllotmentService allotmentService;

    public AllotWaterCommand(AllotmentService allotmentService){
        this.allotmentService = allotmentService;
    }

    @Override
    public Object execute(List<String> tokens) {
        allotmentService.setAllotment( tokens.get(1), new ArrayList<String>(List.of(
            tokens.get(2).split(":")
        )));
        return null;
    }
    
}
