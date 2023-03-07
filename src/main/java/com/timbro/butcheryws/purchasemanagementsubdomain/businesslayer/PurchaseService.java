package com.timbro.butcheryws.purchasemanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.*;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;

import java.util.List;

public interface PurchaseService {

    //This is my Purchase CRUD
    List<PurchaseResponseModel> getPurchases();
    PurchaseResponseModel getPurchaseByPurchaseId(String purchaseId);
    PurchaseResponseModel addPurchase(PurchaseRequestModel purchaseRequestModel);
    PurchaseResponseModel updatePurchase(PurchaseRequestModel purchaseRequestModel, String purchaseId);
    void removePurchase(String purchaseId);

    //This is my Customer CRUD
    PurchaseCustomerResponseModel getPurchaseCustomers(String purchaseId);
    CustomerResponseModel getCustomerInPurchaseByCustomerIdentifier_PurchaseId(String purchaseId, String customerId);
    CustomerResponseModel addCustomerToPurchase(CustomerRequestModel customerRequestModel,String purchaseId);
    CustomerResponseModel updateCustomerInPurchase(CustomerRequestModel customerRequestModel,String purchaseId, String customerId);
    void removeCustomerFromPurchase(String purchaseId, String customerId);

    //This is my Butcher CRUD
    PurchaseButcherResponseModel getPurchaseButchers(String purchaseId);
    ButcherResponseModel getButcherInPurchase(String purchaseId, String butcherId);
    ButcherResponseModel addButcherToPurchase(ButcherRequestModel butcherRequestModel, String purchaseId);
    ButcherResponseModel updateButcherInPurchase(ButcherRequestModel butcherRequestModel, String purchaseId, String butcherId);
    void removeButcherFromPurchase(String purchaseId, String butcherId);

    //This is my Meat CRUD
    PurchaseMeatResponseModel getPurchaseMeats(String purchaseId);
    MeatResponseModel getMeatInPurchase(String purchaseId, String meatId);
    MeatResponseModel addMeatToPurchase(MeatRequestModel meatRequestModel, String purchaseId);
    MeatResponseModel updateMeatInPurchase(MeatRequestModel meatRequestModel, String purchaseId, String meatId);
    void removeMeatFromPurchase(String purchaseId, String meatId);

    //This is my aggregate GET REQUEST
    PurchaseMeatCustomerButcherModel getPurchaseMeatsCustomersButchers(String purchaseId);

}
