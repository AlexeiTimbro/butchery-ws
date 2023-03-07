package com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.Meat;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.MeatIdentifier;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseIdentifier;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.ButcherIdentifier;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MeatRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(expression = "java(meatIdentifier)", target = "meatIdentifier"),
            @Mapping(expression = "java(purchaseIdentifier)", target = "purchaseIdentifier")
    })
    Meat requestModelToEntity(MeatRequestModel meatRequestModel, MeatIdentifier meatIdentifier, PurchaseIdentifier purchaseIdentifier);

}
