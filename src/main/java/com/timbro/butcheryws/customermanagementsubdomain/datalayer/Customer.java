package com.timbro.butcheryws.customermanagementsubdomain.datalayer;

import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseIdentifier;
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

    @Embedded
    private PurchaseIdentifier purchaseIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;


    @Embedded
    private Address address;

    Customer(){
        this.customerIdentifier = new CustomerIdentifier();
    }

    public Customer(String firstName, String lastName, String emailAddress, Address address) {

        this.customerIdentifier = new CustomerIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
