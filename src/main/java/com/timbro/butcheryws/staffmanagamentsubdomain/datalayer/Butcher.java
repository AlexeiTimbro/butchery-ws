package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="butchers")
@Data
public class Butcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private identifier


    @Embedded
    private ButcherIdentifier butcherIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    private Double salary;
    private Double commissionRate;

    @Embedded
    private Address address;

    public Butcher() {
        this.butcherIdentifier = new ButcherIdentifier();
    }

    public Butcher(ButcherIdentifier butcherIdentifier, String firstName, String lastName, String emailAddress, Address address) {
        this.butcherIdentifier = butcherIdentifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
