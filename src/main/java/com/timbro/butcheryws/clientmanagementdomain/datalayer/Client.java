package com.timbro.butcheryws.clientmanagementdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Embedded
    private ClientIdentifier clientIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;


    @Embedded
    private Address address;

    Client() {
        this.clientIdentifier = new ClientIdentifier();
    }

    public Client(String firstName, String lastName, String emailAddress, Address address) {

        this.clientIdentifier = new ClientIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
