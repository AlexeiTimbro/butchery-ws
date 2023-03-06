package com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseResponseMapper {

    @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")
    PurchaseResponseModel entityToResponseModel(Purchase purchase);

    List<PurchaseResponseModel> entityListToResponseModelList(List<Purchase> purchases);

}
