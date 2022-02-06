package com.example.geektrust.entities;

import java.util.List;
import java.util.Map.Entry;

public class Prices {

    private final Double corporationPrice;
    private final Double borwellPrice;
    private final List<Entry<Integer, Double>> tankerPrices;

    
    public Prices(Double corporationPrice, Double borwellPrice, List<Entry<Integer, Double>> tankerPrices) {
        this.corporationPrice = corporationPrice;
        this.borwellPrice = borwellPrice;
        this.tankerPrices = tankerPrices;
    }

    public Double getCorporationPrice() {
        return corporationPrice;
    }

    public Double getBorwellPrice() {
        return borwellPrice;
    }

    public List<Entry<Integer, Double>> getTankerPrices() {
        return tankerPrices;
    }



    

    
}
