package com.timbro.butcheryws.purchasemanagementsubdomain.datalayer;


import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerIdentifier;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.ButcherIdentifier;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="purchases")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private PurchaseIdentifier purchaseIdentifier;

    //@Embedded
    //private CustomerIdentifier customerIdentifier;

    //@Embedded
    //private ButcherIdentifier butcherIdentifier;

    private String dateTime;
    private String totalPrice;

    Purchase(){
        this.purchaseIdentifier = new PurchaseIdentifier();
    }

    public Purchase(String dateTime,String totalPrice) {
        this.purchaseIdentifier = new PurchaseIdentifier();
        this.dateTime = dateTime;
        this.totalPrice= totalPrice;
    }
}
