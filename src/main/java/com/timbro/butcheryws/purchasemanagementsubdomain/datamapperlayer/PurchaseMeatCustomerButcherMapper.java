package com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseMeatCustomerButcherModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseMeatResponseModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMeatCustomerButcherMapper {

    @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")
    @Mapping(expression = "java(meats)", target = "purchaseMeats")
    @Mapping(expression = "java(customers)", target = "purchaseCustomers")
    @Mapping(expression = "java(butchers)", target = "purchaseButchers")
    PurchaseMeatCustomerButcherModel entitiesToResponseModel(Purchase purchase, List<MeatResponseModel> meats, List<CustomerResponseModel> customers, List<ButcherResponseModel> butchers);
}
