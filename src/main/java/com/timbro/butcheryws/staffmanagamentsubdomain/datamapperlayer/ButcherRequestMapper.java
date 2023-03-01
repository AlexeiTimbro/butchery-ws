package com.timbro.butcheryws.staffmanagamentsubdomain.datamapperlayer;

import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ButcherRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "butcherIdentifier", ignore = true)
    Butcher requestModelToEntity(ButcherRequestModel butcherRequestModel);
}
