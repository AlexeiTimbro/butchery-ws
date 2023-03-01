package com.timbro.butcheryws.customermanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Embedded
    private CustomerIdentifier customerIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;


    @Embedded
    private Address address;

    Customer() {
        this.customerIdentifier = new CustomerIdentifier();
    }

    public Customer(CustomerIdentifier customerIdentifier, String firstName, String lastName, String emailAddress, Address address) {
        this.customerIdentifier = customerIdentifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
