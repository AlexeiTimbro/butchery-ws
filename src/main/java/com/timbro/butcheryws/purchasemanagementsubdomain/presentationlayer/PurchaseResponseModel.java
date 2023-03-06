package com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseResponseModel {

    private String purchaseId;
    private String dateTime;
    private String totalPrice;
}
