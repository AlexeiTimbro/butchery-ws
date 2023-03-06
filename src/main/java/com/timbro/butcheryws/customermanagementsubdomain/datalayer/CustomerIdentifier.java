package com.timbro.butcheryws.customermanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CustomerIdentifier {

    private String customerId;

    CustomerIdentifier(){

    }
    public CustomerIdentifier(String customerId){
        this.customerId = customerId;
    }


    public String getCustomerId() {
        return customerId;
    }
}
