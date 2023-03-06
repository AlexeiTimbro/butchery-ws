package com.timbro.butcheryws.purchasemanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerRepository;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerRequestMapper;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerResponseMapper;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseRepository;
import com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer.PurchaseCustomerResponseMapper;
import com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer.PurchaseRequestMapper;
import com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer.PurchaseResponseMapper;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseCustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseRequestModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.PurchaseResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{


    private PurchaseRepository purchaseRepository;
    private PurchaseResponseMapper purchaseResponseMapper;
    private PurchaseRequestMapper purchaseRequestMapper;

    private CustomerRepository customerRepository;
    private CustomerResponseMapper customerResponseMapper;
    private CustomerRequestMapper customerRequestMapper;

    private PurchaseCustomerResponseMapper purchaseCustomerResponseMapper;


    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseResponseMapper purchaseResponseMapper, PurchaseRequestMapper purchaseRequestMapper, CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper, CustomerRequestMapper customerRequestMapper, PurchaseCustomerResponseMapper purchaseCustomerResponseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseResponseMapper = purchaseResponseMapper;
        this.purchaseRequestMapper = purchaseRequestMapper;
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
        this.purchaseCustomerResponseMapper = purchaseCustomerResponseMapper;
    }

    //CRUD FOR PURCHASE


    @Override
    public List<PurchaseResponseModel> getPurchases() {
        return purchaseResponseMapper.entityListToResponseModelList(purchaseRepository.findAll());
    }

    @Override
    public PurchaseResponseModel getPurchaseByPurchaseId(String purchaseId) {
        return purchaseResponseMapper.entityToResponseModel(purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId));
    }

    @Override
    public PurchaseResponseModel addPurchase(PurchaseRequestModel purchaseRequestModel) {
        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel);
        return purchaseResponseMapper.entityToResponseModel(purchaseRepository.save(purchase));
    }

    @Override
    public PurchaseResponseModel updatePurchase(PurchaseRequestModel purchaseRequestModel, String purchaseId) {
        Purchase existingPurchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);

        if(existingPurchase == null){
            return null;
        }
        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel);
        purchase.setId(existingPurchase.getId());
        purchase.setPurchaseIdentifier(existingPurchase.getPurchaseIdentifier());

        return purchaseResponseMapper.entityToResponseModel(purchaseRepository.save(purchase));
    }

    @Override
    public void removePurchase(String purchaseId) {
        Purchase existingPurchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(existingPurchase == null){
            return;
        }
        purchaseRepository.delete(existingPurchase);
    }

    //CRUD FOR CUSTOMER


    @Override
    public PurchaseCustomerResponseModel getPurchaseStudents(String purchaseId) {
        return null;
    }

    @Override
    public CustomerResponseModel getCustomerInPurchaseByCustomerIdentifier_PurchaseId(String purchaseId, String customerId) {
        return null;
    }

    @Override
    public CustomerResponseModel addCustomerToPurchase(CustomerRequestModel customerRequestModel, String purchaseId) {
        return null;
    }

    @Override
    public CustomerResponseModel updateCustomerInPurchase(CustomerRequestModel customerRequestModel, String purchaseId, String customerId) {
        return null;
    }

    @Override
    public void removeCustomerFromPurchase(String purchaseId, String customerId) {

    }
}
