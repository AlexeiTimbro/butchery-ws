package com.timbro.butcheryws.meatmanagementsubdomain.datalayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Address;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerIdentifier;
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

    private String animal;

    private String environment;

    private String texture;

    private String expirationDate;

    private Integer price;

    Meat(){
        this.meatIdentifier = new MeatIdentifier();
    }

    public Meat(MeatIdentifier meatIdentifier, String animal, String environment, String texture, String expirationDate, Integer price) {
        this.meatIdentifier = new MeatIdentifier();
        this.animal = animal;
        this.environment = environment;
        this.texture = texture;
        this.expirationDate = expirationDate;
        this.price = price;
    }
}
