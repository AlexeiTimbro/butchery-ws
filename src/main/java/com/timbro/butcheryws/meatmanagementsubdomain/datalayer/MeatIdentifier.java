package com.timbro.butcheryws.meatmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MeatIdentifier {

    private String meatId;

    //MeatIdentifier(){
    //    this.meatId = UUID.randomUUID().toString();
    //}

    MeatIdentifier(){

    }

    public MeatIdentifier(String meatId) {
        this.meatId = meatId;
    }

    public String getMeatId() {
        return meatId;
    }
}
