package com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ButcherRequestModel {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private Double salary;
    private Double commissionRate;
}
