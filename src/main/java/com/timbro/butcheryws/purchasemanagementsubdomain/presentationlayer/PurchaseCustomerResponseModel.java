package com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseCustomerResponseModel {

    private String purchaseId;
    private String dateTime;
    private String totalPrice;
    private List<CustomerResponseModel> purchaseCustomers;
}
