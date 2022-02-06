package com.example.geektrust.entities;

public class Allotment {

    private final Integer corporationAlloted;
    private final Integer borwellAlloted;

    public Allotment(Integer corporationAlloted, Integer borwellAlloted) {
        this.corporationAlloted = corporationAlloted;
        this.borwellAlloted = borwellAlloted;
    }

    public Integer getCorporationAlloted() {
        return corporationAlloted;
    }

    public Integer getBorwellAlloted() {
        return borwellAlloted;
    }

    

    
    
}
