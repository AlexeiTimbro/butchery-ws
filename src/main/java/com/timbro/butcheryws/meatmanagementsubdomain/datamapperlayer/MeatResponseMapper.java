package com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.Meat;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MeatResponseMapper {

    @Mapping(expression = "java(meat.getMeatIdentifier().getMeatId())", target = "meatId")
    MeatResponseModel entityToResponseModel(Meat meat);

    List<MeatResponseModel> entityListToResponseModelList(List<Meat> meats);
}
