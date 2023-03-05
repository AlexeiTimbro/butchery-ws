package com.timbro.butcheryws.purchasemanagementsubdomain.datalayer;


import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Purchase findByPurchaseIdentifier_PurchaseId(String purchaseId);
}
