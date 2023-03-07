package com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer;


import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {


    @Mapping(expression = "java(customer.getCustomerIdentifier().getCustomerId())", target = "customerId")
    @Mapping(expression = "java(customer.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")
    CustomerResponseModel entityToResponseModel(Customer customer);

    List<CustomerResponseModel> entityListToResponseModelList(List<Customer> customers);


}
