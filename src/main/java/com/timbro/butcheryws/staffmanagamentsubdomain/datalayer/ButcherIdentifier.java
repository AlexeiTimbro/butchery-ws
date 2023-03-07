package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ButcherIdentifier {

    private String butcherId;

    //ButcherIdentifier() {
    //    this.butcherId = UUID.randomUUID().toString();
    //}

    ButcherIdentifier(){

    }

    public ButcherIdentifier(String butcherId) {
        this.butcherId = butcherId;
    }

    public String getButcherId() {
        return butcherId;
    }
}
