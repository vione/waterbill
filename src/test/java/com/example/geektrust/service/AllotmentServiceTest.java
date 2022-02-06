package com.example.geektrust.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.entities.Allotment;
import com.example.geektrust.entities.Apartment;
import com.example.geektrust.repositories.ApartmentRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Testing Allotment Service")
@ExtendWith(MockitoExtension.class)
public class AllotmentServiceTest {
    
    @Mock
    ApartmentRepository apartmentRepository;

    @InjectMocks
    AllotmentService allotmentService;

    @Test
    @DisplayName("setAllotmentTest Will Check if the apartmentRepository.addApartmentIscalled")
    public void setAllotmentTest_Should_Call_addApartment(){

        //Arrange
        Apartment apartment = new Apartment("1", 3, 0, new Allotment(3, 5));
        when(apartmentRepository.getApartmentByID(eq("1"))).thenReturn(null);

        //Act
        allotmentService.setAllotment("1", "2", new ArrayList<String>(List.of("3","5")));

        //Assert
        verify(apartmentRepository).addApartment(apartment);
    }

    @Test
    @DisplayName("addGuestTest Will check if the number of guest in the object has increased")
    public void addGuestTest_Should_Increase_Guests_In_Same_Object(){
        
        //Arrange
        Apartment apartment = new Apartment("1", 3, 0, new Allotment(3, 5));
        when(apartmentRepository.getApartmentByID(eq("1"))).thenReturn(apartment);

        //Act
        allotmentService.addGuests(3);

        //Asert
        Assertions.assertEquals(apartment.getGuest(),3);

    }

}
