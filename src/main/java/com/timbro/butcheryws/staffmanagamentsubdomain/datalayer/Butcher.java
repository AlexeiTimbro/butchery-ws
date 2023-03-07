package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;


import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseIdentifier;
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

    @Embedded
    private PurchaseIdentifier purchaseIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Double salary;
    private Double commissionRate;
    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;



    public Butcher() {
        this.butcherIdentifier = new ButcherIdentifier();
    }

    public Butcher(String firstName, String lastName, String emailAddress, String phoneNumber, Double salary, Double commissionRate, String streetAddress, String city, String province, String country, String postalCode) {
        this.butcherIdentifier = new ButcherIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }
}
