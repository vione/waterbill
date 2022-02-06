package com.example.geektrust.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entities.Allotment;
import com.example.geektrust.entities.Apartment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Apartment Repository Test")
public class ApartmentRepositoryTest {

    private ApartmentRepository apartmentRepository;

    @BeforeEach
    public void setup(){
        Map<String,Apartment> apartmentIdMap = new HashMap<>();
        apartmentIdMap.put("1", new Apartment("1", 3, 0, new Allotment(1, 5)));
        apartmentIdMap.put("2", new Apartment("2", 5, 0, new Allotment(2, 5)));
        apartmentRepository = new ApartmentRepository(apartmentIdMap);
    }


    @Test
    @DisplayName("getApartmentByIdTest - Should Return Existing Apartment")
    public void getApartmentById_Should_Return_A_Apartment(){

        //Arrange
        Apartment expected = new Apartment("1", 3, 0, new Allotment(1, 5));

        //Act
        Apartment original = apartmentRepository.getApartmentByID("1");

        //Assert
        Assertions.assertEquals(expected, original);

    }

    @Test
    @DisplayName("getApartmentByIdTest - Should Return Null for Non Existing Apartment")
    public void getApartmentById_Should_Return_Null(){
        
        //Act
        Apartment actual = apartmentRepository.getApartmentByID("3");

        //Assert
        Assertions.assertNull(actual);
    }

    @Test
    @DisplayName("addApartmentTest - Should Return the new apartment after adding")
    public void addApartmentTest_Should_Return_New_Apartment(){

        //Arrange
        Apartment apartment = new Apartment("3", 3, 0, new Allotment(3, 5));
        apartmentRepository.addApartment(apartment);

        //Act
        Apartment actual = apartmentRepository.getApartmentByID("3");

        //Assert
        Assertions.assertEquals(apartment, actual);
    }
    
}
