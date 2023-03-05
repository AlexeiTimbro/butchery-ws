package com.timbro.butcheryws.meatmanagementsubdomain.datalayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRepository extends JpaRepository<Meat, Integer> {

    Meat findByMeatIdentifier_MeatId(String meatId);
}
