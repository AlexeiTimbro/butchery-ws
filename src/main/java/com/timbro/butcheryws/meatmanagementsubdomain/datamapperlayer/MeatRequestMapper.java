package com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.Meat;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeatRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "meatIdentifier", ignore = true)
    Meat requestModelToEntity(MeatRequestModel meatRequestModel);

}
