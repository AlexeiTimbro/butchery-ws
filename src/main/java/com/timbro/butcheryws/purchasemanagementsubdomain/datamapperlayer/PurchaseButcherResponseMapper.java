package com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseButcherResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseCustomerResponseModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseButcherResponseMapper {

    @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")
    @Mapping(expression = "java(butchers)", target = "purchaseButchers")
    PurchaseButcherResponseModel entitiesToResponseModel(Purchase purchase, List<ButcherResponseModel> butchers);
}
