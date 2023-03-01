package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ButcherRepository extends JpaRepository<Butcher, Integer> {

    Butcher findByButcherIdentifier_ButcherId(String butcherId);
}
