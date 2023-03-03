package com.timbro.butcheryws.inventorymanagementsubdomain.datalayer.inventory;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventories")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private id

    @Embedded
    private InventoryIdentifier inventoryIdentifier; //public id

    private String type;

    public Inventory() {
        this.inventoryIdentifier = new InventoryIdentifier();
    }

    public Inventory(String type) {
        this.inventoryIdentifier = new InventoryIdentifier();
        this.type = type;
    }
}