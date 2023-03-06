package com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchaseIdentifier", ignore = true)
    Purchase requestModelToEntity(PurchaseRequestModel purchaseRequestModel);
}
