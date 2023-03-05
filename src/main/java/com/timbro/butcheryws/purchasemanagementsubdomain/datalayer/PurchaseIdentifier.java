package com.timbro.butcheryws.purchasemanagementsubdomain.datalayer;


import jakarta.persistence.Embeddable;

@Embeddable
public class PurchaseIdentifier {

    private String purchaseId;


    PurchaseIdentifier(){

    }

    public PurchaseIdentifier(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }
}
