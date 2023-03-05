package com.timbro.butcheryws.meatmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MeatIdentifier {

    private String meatId;

    MeatIdentifier(){
        this.meatId = UUID.randomUUID().toString();
    }

    public String getMeatId() {
        return meatId;
    }
}
