package com.timbro.butcheryws.staffmanagamentsubdomain.datamapperlayer;

import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ButcherResponseMapper {


    @Mapping(expression = "java(butcher.getButcherIdentifier().getButcherId())", target = "butcherId")
    @Mapping(expression = "java(butcher.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")
    ButcherResponseModel entityToResponseModel(Butcher butcher);

    List<ButcherResponseModel> entityListToResponseModelList(List<Butcher> butchers);
}
