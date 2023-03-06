package com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerIdentifier;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseIdentifier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(expression = "java(customerIdentifier)", target = "customerIdentifier"),
            @Mapping(expression = "java(purchaseIdentifier)", target = "purchaseIdentifier")
    })
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel, CustomerIdentifier customerIdentifier, PurchaseIdentifier purchaseIdentifier);

}
