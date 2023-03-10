package com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseButcherResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseMeatResponseModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMeatResponseMapper {

    @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")
    @Mapping(expression = "java(meats)", target = "purchaseMeats")
    PurchaseMeatResponseModel entitiesToResponseModel(Purchase purchase, List<MeatResponseModel> meats);
}
