package com.timbro.butcheryws.meatmanagementsubdomain.datalayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeatRepository extends JpaRepository<Meat, Integer> {

    List<Meat> findMeatByPurchaseIdentifier_PurchaseId(String purchaseId);
    Meat findByPurchaseIdentifier_PurchaseIdAndAndMeatIdentifier_MeatId(String purchaseId, String meatId);
    Meat findMeatByMeatIdentifier_MeatId(String meatId);

}
