package com.example.geektrust.dto;

public class Bill {
    
    private final String waterConsumed;
    private final String billAmount;
    
    public Bill(String waterConsumed, String billAmount) {
        this.waterConsumed = waterConsumed;
        this.billAmount = billAmount;
    }

    public String getWaterConsumed() {
        return waterConsumed;
    }

    public String getBillAmount() {
        return billAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((billAmount == null) ? 0 : billAmount.hashCode());
        result = prime * result + ((waterConsumed == null) ? 0 : waterConsumed.hashCode());
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
        Bill other = (Bill) obj;
        if (billAmount == null) {
            if (other.billAmount != null)
                return false;
        } else if (!billAmount.equals(other.billAmount))
            return false;
        if (waterConsumed == null) {
            if (other.waterConsumed != null)
                return false;
        } else if (!waterConsumed.equals(other.waterConsumed))
            return false;
        return true;
    }

    

    
    
}
