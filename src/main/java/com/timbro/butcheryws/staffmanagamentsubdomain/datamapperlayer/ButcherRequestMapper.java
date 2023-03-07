package com.timbro.butcheryws.staffmanagamentsubdomain.datamapperlayer;

import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseIdentifier;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.ButcherIdentifier;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ButcherRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(expression = "java(butcherIdentifier)", target = "butcherIdentifier"),
            @Mapping(expression = "java(purchaseIdentifier)", target = "purchaseIdentifier")
    })
    Butcher requestModelToEntity(ButcherRequestModel butcherRequestModel, ButcherIdentifier butcherIdentifier, PurchaseIdentifier purchaseIdentifier);
}
