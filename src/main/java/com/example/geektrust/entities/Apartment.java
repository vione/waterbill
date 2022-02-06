package com.example.geektrust.entities;


//Building the Apartment class generalizes the concept of Apartments
//In case we wan't dedicated classes for 2BHK and 3BHK, we can do so

public class Apartment {

    private final String apartmentID;
    private final Integer people;
    private Integer guest;
    private Allotment allotment;

    public Apartment(String apartmentID, Integer people, Integer guest, Allotment allotment){
        this.apartmentID = apartmentID;
        this.people = people;
        this.guest = guest;
        this.allotment = allotment;
    }

    public Integer addGuest(Integer numberOfGuest){
        this.guest += numberOfGuest;
        return guest;
    }

    public Integer getGuest(){
        return this.guest;
    }

    public Integer getPeople(){
        return this.people;
    }

    public String getApartmentID(){
        return this.apartmentID;
    }

    public Allotment getAllotment() {
        return allotment;
    }

    public void setAllotment(Allotment allotment) {
        this.allotment = allotment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apartmentID == null) ? 0 : apartmentID.hashCode());
        result = prime * result + ((people == null) ? 0 : people.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Apartment other = (Apartment) obj;
        if (apartmentID == null) {
            if (other.apartmentID != null)
                return false;
        } else if (!apartmentID.equals(other.apartmentID))
            return false;
        if (people == null) {
            if (other.people != null)
                return false;
        } else if (!people.equals(other.people))
            return false;
        return true;
    }

    
    
    
}
