package com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MeatResponseModel {

    private String meatId;
    private String purchaseId;
    private String animal;
    private String environment;
    private String texture;
    private String expirationDate;
    private Integer price;
}
