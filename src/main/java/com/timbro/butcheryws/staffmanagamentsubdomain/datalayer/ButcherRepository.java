package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ButcherRepository extends JpaRepository<Butcher, Integer> {

    List<Butcher> findButchersByPurchaseIdentifier_PurchaseId(String purchaseId);
    Butcher findByPurchaseIdentifier_PurchaseIdAndButcherIdentifier_ButcherId(String purchaseId, String butcherId);
    Butcher findButcherByButcherIdentifier_ButcherId(String ButcherId);
}
