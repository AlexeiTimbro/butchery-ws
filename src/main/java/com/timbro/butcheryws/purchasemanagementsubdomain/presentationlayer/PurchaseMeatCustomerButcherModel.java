package com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseMeatCustomerButcherModel {

    private String purchaseId;
    private String dateTime;
    private String totalPrice;
    private List<MeatResponseModel> purchaseMeats;
    private List<CustomerResponseModel> purchaseCustomers;
    private List<ButcherResponseModel> purchaseButchers;
}
