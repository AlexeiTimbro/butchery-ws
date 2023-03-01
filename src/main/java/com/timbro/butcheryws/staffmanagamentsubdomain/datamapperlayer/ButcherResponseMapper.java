package com.timbro.butcheryws.staffmanagamentsubdomain.datamapperlayer;

import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ButcherResponseMapper {


    @Mapping(expression = "java(butcher.getButcherIdentifier().getButcherId())", target = "butcherId")
    @Mapping(expression = "java(butcher.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(butcher.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(butcher.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(butcher.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(butcher.getAddress().getPostalCode())", target = "postalCode")
    ButcherResponseModel entityToResponseModel(Butcher butcher);

    List<ButcherResponseModel> entityListToResponseModelList(List<Butcher> butchers);
}
