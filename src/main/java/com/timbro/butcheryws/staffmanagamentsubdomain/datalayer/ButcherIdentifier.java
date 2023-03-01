package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ButcherIdentifier {

    private String butcherId;

    ButcherIdentifier() {
        this.butcherId = UUID.randomUUID().toString();
    }

    public String getButcherId() {
        return butcherId;
    }
}
