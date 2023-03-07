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
    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;


    Customer(){
        this.customerIdentifier = new CustomerIdentifier();
    }

    public Customer(String firstName, String lastName, String emailAddress, String streetAddress, String city, String province, String country, String postalCode) {
        this.customerIdentifier = new CustomerIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }
}
