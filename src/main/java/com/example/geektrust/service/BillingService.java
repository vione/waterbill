package com.example.geektrust.service;

import java.util.List;
import java.util.Map.Entry;

import com.example.geektrust.dto.Bill;
import com.example.geektrust.entities.Apartment;
import com.example.geektrust.entities.Prices;
import com.example.geektrust.repositories.ApartmentRepository;

public class BillingService {
    
    private int dailyConsumptionPerCapita = 10;
    private int billingDays = 30;
    private ApartmentRepository apartmentRepository;
    private final Prices prices;

    public BillingService(ApartmentRepository apartmentRepository, Prices prices){
        this.apartmentRepository = apartmentRepository;
        this.prices = prices;
    }

    public Bill getBill(String apartmentId){
        Apartment apartment = apartmentRepository.getApartmentByID(apartmentId);
        Integer waterConsumed = getWaterConsumption(apartment);
        Integer billAmount = calcualteAmount(apartment);
        return new Bill(waterConsumed.toString(), billAmount.toString());
    }

    private Integer getWaterConsumption(Apartment apartment){
        return (apartment.getPeople() + apartment.getGuest())*billingDays
        *dailyConsumptionPerCapita;
    }

    private Integer calcualteAmount(Apartment apartment){
        Integer peopleConsumption = apartment.getPeople()*billingDays*dailyConsumptionPerCapita;
        Double corporationCharges = peopleConsumption*apartment.getAllotment().getCorporationAlloted()
                /(apartment.getAllotment().getBorwellAlloted() + apartment.getAllotment().getCorporationAlloted())
                *prices.getCorporationPrice();
        Double borwellCharges = peopleConsumption*apartment.getAllotment().getBorwellAlloted()
                /(apartment.getAllotment().getBorwellAlloted() + apartment.getAllotment().getCorporationAlloted())
                *prices.getBorwellPrice();
        Integer guestConsumption = apartment.getGuest()*billingDays*dailyConsumptionPerCapita;
        Double tankerCharges = getTankerBill(guestConsumption);

        return (int)Math.round(corporationCharges + borwellCharges + tankerCharges);
    }

    private Double getTankerBill(Integer consumerWater){
        Double totalCharges = 0.0;
        List<Entry<Integer,Double>> slabs = prices.getTankerPrices();
        for(Entry<Integer,Double> slab:slabs){
            if(consumerWater >= slab.getKey()){
                totalCharges+= slab.getKey()*slab.getValue();
                consumerWater -= slab.getKey();
            }
            else{
                totalCharges += consumerWater*slab.getValue();
                break;
            }
        }
        return totalCharges;
    }
}
