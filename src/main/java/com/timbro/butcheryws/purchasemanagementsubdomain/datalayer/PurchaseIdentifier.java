package com.timbro.butcheryws.purchasemanagementsubdomain.datalayer;


import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class PurchaseIdentifier {

    private String purchaseId;


    PurchaseIdentifier(){
        this.purchaseId = UUID.randomUUID().toString();
    }

    public String getPurchaseId() {
        return purchaseId;
    }
}
