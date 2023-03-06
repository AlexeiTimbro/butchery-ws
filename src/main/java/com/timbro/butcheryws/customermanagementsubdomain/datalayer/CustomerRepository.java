package com.timbro.butcheryws.customermanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Embeddable
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllCustomersByPurchaseIdentifier_PurchaseId(String purchaseId);
    Customer findByCustomerIdentifier_CustomerId(String customerId);
    Customer findByPurchaseIdentifier_PurchaseIdAndCustomerIdentifier_CustomerId(String purchaseId, String customerId);

}
