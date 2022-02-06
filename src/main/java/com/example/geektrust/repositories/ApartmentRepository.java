package com.example.geektrust.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entities.Apartment;

public class ApartmentRepository {
    
    private final Map<String,Apartment> apartementIdMap;
    
    public ApartmentRepository(){
        apartementIdMap = new HashMap<>();
    }

    public ApartmentRepository(Map<String, Apartment> apartmentIdMap){
        this.apartementIdMap = apartmentIdMap;
    }

    public Apartment getApartmentByID(String apartmentId){
        return apartementIdMap.get(apartmentId);
    }

    public void addApartment(Apartment apartment){
        apartementIdMap.put(apartment.getApartmentID(), apartment);
    }
}
