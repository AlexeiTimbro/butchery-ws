package com.timbro.butcheryws.customermanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;

import java.util.List;

public interface CustomerService {


    List<CustomerResponseModel> getCustomers();

    CustomerResponseModel getCustomerByCustomerId(String customerId);

    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel, String purchaseId);

    CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId);

    void removeCustomer(String customerId);
}
