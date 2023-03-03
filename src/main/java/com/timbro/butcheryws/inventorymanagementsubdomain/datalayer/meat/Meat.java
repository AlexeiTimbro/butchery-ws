package com.timbro.butcheryws.inventorymanagementsubdomain.datalayer.meat;

import com.timbro.butcheryws.inventorymanagementsubdomain.datalayer.inventory.InventoryIdentifier;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="meats")
@Data
public class Meat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private MeatIdentifier meatIdentifier;

    @Embedded
    private InventoryIdentifier inventoryIdentifier;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Environment environment;

    private String name;

    private String animal;

    private String texture;



}
