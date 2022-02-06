package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.dto.Bill;
import com.example.geektrust.service.BillingService;

public class BillCommand implements ICommand{

    private BillingService billingService;

    private String defaultApartmentId = "1";

    public BillCommand(BillingService billingService){
        this.billingService = billingService;
    }

    @Override
    public Object execute(List<String> tokeStings) {
        Bill bill =  billingService.getBill(defaultApartmentId);
        System.out.println(bill.getWaterConsumed() + " " + bill.getBillAmount());
        return bill;
    }
    
}
