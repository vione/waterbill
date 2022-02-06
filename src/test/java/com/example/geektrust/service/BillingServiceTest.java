package com.example.geektrust.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.geektrust.dto.Bill;
import com.example.geektrust.entities.*;
import com.example.geektrust.repositories.ApartmentRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Testing Billing Services")
@ExtendWith(MockitoExtension.class)
public class BillingServiceTest {

    @Mock
    private ApartmentRepository apartmentRepository;

    @Mock
    private Prices prices;

    @InjectMocks
    private BillingService billingService;

    @Test
    @DisplayName("getBillTest - Should return expected Bill object")
    public void getBillTest_ShouldReturnExpectedBillObject(){
        
        //Arrange
        Bill expected = new Bill("2400", "5215");
        Apartment apartment = new Apartment("1", 3, 5, new Allotment(3, 7));
        List<Entry<Integer,Double>> tankerPrices = new ArrayList<>();
        tankerPrices.add(Map.entry(500-0, 2.0));
        tankerPrices.add(Map.entry(1500-500, 3.0));
        tankerPrices.add(Map.entry(3000-1500, 5.0));
        tankerPrices.add(Map.entry(Integer.MAX_VALUE-3000, 8.0));
        when(apartmentRepository.getApartmentByID(eq("1"))).thenReturn(apartment);
        when(prices.getBorwellPrice()).thenReturn(1.5);
        when(prices.getCorporationPrice()).thenReturn(1.0);
        when(prices.getTankerPrices()).thenReturn(tankerPrices);

        //Act
        Bill original = billingService.getBill("1");

        //Assert
        Assertions.assertEquals(expected, original);

    }

    
}
