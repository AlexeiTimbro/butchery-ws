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

    @Embedded
    private CustomerIdentifier customerIdentifier;

    @Embedded
    private ButcherIdentifier butcherIdentifier;

    private Date date;

    Purchase(){

    }

    public Purchase(PurchaseIdentifier purchaseIdentifier, Date date) {
        this.purchaseIdentifier = purchaseIdentifier;
        this.date = date;
    }
}
