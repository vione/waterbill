package com.example.geektrust.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.geektrust.command.*;
import com.example.geektrust.entities.Prices;
import com.example.geektrust.repositories.ApartmentRepository;
import com.example.geektrust.service.*;

public class ApplicationConfiguration {

    private ApartmentRepository apartmentRepository = new ApartmentRepository();
    
    private AllotmentService allotmentService = new AllotmentService(apartmentRepository);
    private BillingService billingService;

    private ICommand allot_water = new AllotWaterCommand(allotmentService);
    private ICommand add_guest = new AddGuests(allotmentService);
    private ICommand bill;

    private CommandExecutor commandExecutor = new CommandExecutor();

    public ApplicationConfiguration(){
        List<Entry<Integer,Double>> tankerPrices = new ArrayList<>();
        tankerPrices.add(Map.entry(500-0, 2.0));
        tankerPrices.add(Map.entry(1500-500, 3.0));
        tankerPrices.add(Map.entry(3000-1500, 5.0));
        tankerPrices.add(Map.entry(Integer.MAX_VALUE-3000, 8.0));
        Prices prices = new Prices(1.0, 1.5 ,tankerPrices);
        
        billingService = new BillingService(apartmentRepository, prices);
        
        bill = new BillCommand(billingService);
        commandExecutor.register("ALLOT_WATER", allot_water);
        commandExecutor.register("ADD_GUESTS", add_guest);
        commandExecutor.register("BILL", bill);

    }

    public CommandExecutor getCommandExecutor(){
        return commandExecutor;    }
}
