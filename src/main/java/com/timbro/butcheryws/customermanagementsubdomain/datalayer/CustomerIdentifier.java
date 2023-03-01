package com.timbro.butcheryws.customermanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CustomerIdentifier {

    private String customerId;

    CustomerIdentifier(){
        this.customerId = UUID.randomUUID().toString();
    }

    public String getCustomerId() {
        return customerId;
    }
}
