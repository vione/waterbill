package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.entities.Allotment;
import com.example.geektrust.entities.Apartment;
import com.example.geektrust.repositories.ApartmentRepository;

public class AllotmentService {
    
    private Integer apartmentIdCount = 0;
    private String defaulApartmentId = "1";

    private ApartmentRepository apartmentRepository;

    public AllotmentService(ApartmentRepository apartmentRepository){
        this.apartmentRepository = apartmentRepository;
    }
    
    //To keep flexiblity in case we are considering to consider different Appatments
    //This function will use a manuallly given apartmentId
    //In case it consides with the already given by ID. It will cause a clash
    public void setAllotment(String apartmentId, String type, List<String> allotment){
        if(apartmentRepository.getApartmentByID(apartmentId) != null){
            while(apartmentRepository.getApartmentByID(apartmentId) != null){
                apartmentId = (++apartmentIdCount).toString();
            }
        }
        Integer people = type.equals("2")?3:5;
        apartmentRepository.addApartment(new Apartment(apartmentId, people, 0, 
            new Allotment(Integer.parseInt(allotment.get(0)), 
                        Integer.parseInt(allotment.get(1)))));
    }

    //Considering the scope that only Allotment and Types are given as input
    public void setAllotment(String type, List<String> allotment){
        setAllotment((++apartmentIdCount).toString(), type, allotment);
    }

    public void addGuests(String apartmentId, Integer noOfGuests){
        Apartment apartment = apartmentRepository.getApartmentByID(apartmentId);
        apartment.addGuest(noOfGuests);
        apartmentRepository.addApartment(apartment);
    }

    public void addGuests(Integer noOfGuests){
        if(apartmentRepository.getApartmentByID("1") == null) {
            System.out.println("No proper allotment defined");
        }
        else {
            addGuests(defaulApartmentId,noOfGuests);
        }
    }
}
