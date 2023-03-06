package com.timbro.butcheryws.purchasemanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseCustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseRequestModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseResponseModel;

import java.util.List;

public interface PurchaseService {

    //This is my Purchase CRUD
    List<PurchaseResponseModel> getPurchases();
    PurchaseResponseModel getPurchaseByPurchaseId(String purchaseId);
    PurchaseResponseModel addPurchase(PurchaseRequestModel purchaseRequestModel);
    PurchaseResponseModel updatePurchase(PurchaseRequestModel purchaseRequestModel, String purchaseId);
    void removePurchase(String purchaseId);

    //This is my Customer CRUD
    PurchaseCustomerResponseModel getPurchaseStudents(String purchaseId);
    CustomerResponseModel getCustomerInPurchaseByCustomerIdentifier_PurchaseId(String purchaseId, String customerId);
    CustomerResponseModel addCustomerToPurchase(CustomerRequestModel customerRequestModel,String purchaseId);
    CustomerResponseModel updateCustomerInPurchase(CustomerRequestModel customerRequestModel,String purchaseId, String customerId);
    void removeCustomerFromPurchase(String purchaseId, String customerId);
}
