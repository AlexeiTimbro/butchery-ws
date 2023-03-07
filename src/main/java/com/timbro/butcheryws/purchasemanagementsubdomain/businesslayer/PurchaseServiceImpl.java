package com.timbro.butcheryws.purchasemanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerIdentifier;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerRepository;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerRequestMapper;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerResponseMapper;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.Meat;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.MeatIdentifier;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.MeatRepository;
import com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer.MeatRequestMapper;
import com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer.MeatResponseMapper;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseRepository;
import com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer.*;
import com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer.*;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.ButcherIdentifier;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.ButcherRepository;
import com.timbro.butcheryws.staffmanagamentsubdomain.datamapperlayer.ButcherRequestMapper;
import com.timbro.butcheryws.staffmanagamentsubdomain.datamapperlayer.ButcherResponseMapper;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
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

    private ButcherRepository butcherRepository;
    private ButcherRequestMapper butcherRequestMapper;
    private ButcherResponseMapper butcherResponseMapper;

    private MeatRepository meatRepository;
    private MeatResponseMapper meatResponseMapper;
    private MeatRequestMapper meatRequestMapper;

    private PurchaseCustomerResponseMapper purchaseCustomerResponseMapper;
    private PurchaseButcherResponseMapper purchaseButcherResponseMapper;
    private PurchaseMeatResponseMapper purchaseMeatResponseMapper;
    private PurchaseMeatCustomerButcherMapper purchaseMeatCustomerButcherMapper;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseResponseMapper purchaseResponseMapper, PurchaseRequestMapper purchaseRequestMapper, CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper, CustomerRequestMapper customerRequestMapper, ButcherRepository butcherRepository, ButcherRequestMapper butcherRequestMapper, ButcherResponseMapper butcherResponseMapper, MeatRepository meatRepository, MeatResponseMapper meatResponseMapper, MeatRequestMapper meatRequestMapper, PurchaseCustomerResponseMapper purchaseCustomerResponseMapper, PurchaseButcherResponseMapper purchaseButcherResponseMapper, PurchaseMeatResponseMapper purchaseMeatResponseMapper, PurchaseMeatCustomerButcherMapper purchaseMeatCustomerButcherMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseResponseMapper = purchaseResponseMapper;
        this.purchaseRequestMapper = purchaseRequestMapper;
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
        this.butcherRepository = butcherRepository;
        this.butcherRequestMapper = butcherRequestMapper;
        this.butcherResponseMapper = butcherResponseMapper;
        this.meatRepository = meatRepository;
        this.meatResponseMapper = meatResponseMapper;
        this.meatRequestMapper = meatRequestMapper;
        this.purchaseCustomerResponseMapper = purchaseCustomerResponseMapper;
        this.purchaseButcherResponseMapper = purchaseButcherResponseMapper;
        this.purchaseMeatResponseMapper = purchaseMeatResponseMapper;
        this.purchaseMeatCustomerButcherMapper = purchaseMeatCustomerButcherMapper;
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
    public PurchaseCustomerResponseModel getPurchaseCustomers(String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);

        if(purchase == null){
            return null;
        }
        List<Customer>customers = customerRepository.findAllCustomersByPurchaseIdentifier_PurchaseId(purchaseId);
        List<CustomerResponseModel> customerResponseModels = customerResponseMapper.entityListToResponseModelList(customers);

        return purchaseCustomerResponseMapper.entitiesToResponseModel(purchase, customerResponseModels);
    }

    @Override
    public CustomerResponseModel getCustomerInPurchaseByCustomerIdentifier_PurchaseId(String purchaseId, String customerId) {
        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return null;
        }

        Customer foundCustomer = customerRepository.findByPurchaseIdentifier_PurchaseIdAndCustomerIdentifier_CustomerId(purchaseId,customerId);

        if(foundCustomer == null){
            return null;
        }

        return customerResponseMapper.entityToResponseModel(foundCustomer);
    }

    @Override
    public CustomerResponseModel addCustomerToPurchase(CustomerRequestModel customerRequestModel, String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(purchase == null){
            return null;
        }
        CustomerIdentifier customerIdentifier = new CustomerIdentifier(customerRequestModel.getCustomerId());
        Customer customer= customerRequestMapper.requestModelToEntity(customerRequestModel, customerIdentifier, purchase.getPurchaseIdentifier());
        Customer saved = customerRepository.save(customer);

        return customerResponseMapper.entityToResponseModel(saved);
    }

    @Override
    public CustomerResponseModel updateCustomerInPurchase(CustomerRequestModel customerRequestModel, String purchaseId, String customerId) {

        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return null;
        }
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if(customer== null){
            return null;
        }

        Customer updatedCustomer = customerRequestMapper.requestModelToEntity(customerRequestModel,customer.getCustomerIdentifier(),customer.getPurchaseIdentifier());
        updatedCustomer.setId(customer.getId());

        return customerResponseMapper.entityToResponseModel(customerRepository.save(updatedCustomer));
    }

    @Override
    public void removeCustomerFromPurchase(String purchaseId, String customerId) {
        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return;
        }
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if(customer== null){
            return;
        }
        customerRepository.delete(customer);

    }


    //CRUD FOR BUTCHER


    @Override
    public PurchaseButcherResponseModel getPurchaseButchers(String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(purchase == null){
            return null;
        }
        List<Butcher> butchers = butcherRepository.findButchersByPurchaseIdentifier_PurchaseId(purchaseId);
        List<ButcherResponseModel> butcherResponseModels = butcherResponseMapper.entityListToResponseModelList(butchers);

        return purchaseButcherResponseMapper.entitiesToResponseModel(purchase,butcherResponseModels);
    }

    @Override
    public ButcherResponseModel getButcherInPurchase(String purchaseId, String butcherId) {
        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return null;
        }

        Butcher foundButcher = butcherRepository.findByPurchaseIdentifier_PurchaseIdAndButcherIdentifier_ButcherId(purchaseId, butcherId);

        if(foundButcher == null){
            return null;
        }
        return butcherResponseMapper.entityToResponseModel(foundButcher);
    }

    @Override
    public ButcherResponseModel addButcherToPurchase(ButcherRequestModel butcherRequestModel, String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(purchase == null){
            return null;
        }

        ButcherIdentifier butcherIdentifier = new ButcherIdentifier(butcherRequestModel.getButcherId());
        Butcher butcher = butcherRequestMapper.requestModelToEntity(butcherRequestModel,butcherIdentifier,purchase.getPurchaseIdentifier());
        Butcher saved = butcherRepository.save(butcher);
        return butcherResponseMapper.entityToResponseModel(saved);

    }

    @Override
    public ButcherResponseModel updateButcherInPurchase(ButcherRequestModel butcherRequestModel, String purchaseId, String butcherId) {

        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return null;
        }

        Butcher butcher = butcherRepository.findButcherByButcherIdentifier_ButcherId(butcherId);
        if(butcher == null){
            return null;
        }

        Butcher updatedButcher = butcherRequestMapper.requestModelToEntity(butcherRequestModel,butcher.getButcherIdentifier(),butcher.getPurchaseIdentifier());
        updatedButcher.setId(butcher.getId());
        return butcherResponseMapper.entityToResponseModel(butcherRepository.save(updatedButcher));
    }

    @Override
    public void removeButcherFromPurchase(String purchaseId, String butcherId) {

        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return;
        }
        Butcher butcher = butcherRepository.findButcherByButcherIdentifier_ButcherId(butcherId);
        if(butcher == null){
            return;
        }
        butcherRepository.delete(butcher);
    }


        //CRUD FOR MEAT


    @Override
    public PurchaseMeatResponseModel getPurchaseMeats(String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(purchase == null){
            return null;
        }
        List<Meat> meats = meatRepository.findMeatByPurchaseIdentifier_PurchaseId(purchaseId);
        List<MeatResponseModel> meatResponseModels = meatResponseMapper.entityListToResponseModelList(meats);

        return purchaseMeatResponseMapper.entitiesToResponseModel(purchase, meatResponseModels);
    }

    @Override
    public MeatResponseModel getMeatInPurchase(String purchaseId, String meatId) {
        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return null;
        }
        Meat foundMeat = meatRepository.findByPurchaseIdentifier_PurchaseIdAndAndMeatIdentifier_MeatId(purchaseId,meatId);

        if(foundMeat == null){
            return null;
        }
        return meatResponseMapper.entityToResponseModel(foundMeat);
    }

    @Override
    public MeatResponseModel addMeatToPurchase(MeatRequestModel meatRequestModel, String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(purchase == null){
            return null;
        }
        MeatIdentifier meatIdentifier = new MeatIdentifier(meatRequestModel.getMeatId());
        Meat meat= meatRequestMapper.requestModelToEntity(meatRequestModel,meatIdentifier,purchase.getPurchaseIdentifier());
        Meat saved = meatRepository.save(meat);

        return meatResponseMapper.entityToResponseModel(saved);
    }

    @Override
    public MeatResponseModel updateMeatInPurchase(MeatRequestModel meatRequestModel, String purchaseId, String meatId) {
        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return null;
        }

        Meat meat = meatRepository.findMeatByMeatIdentifier_MeatId(meatId);

        if(meat == null){
            return null;
        }

        Meat updatedMeat = meatRequestMapper.requestModelToEntity(meatRequestModel,meat.getMeatIdentifier(),meat.getPurchaseIdentifier());
        updatedMeat.setId(meat.getId());
        return meatResponseMapper.entityToResponseModel(meatRepository.save(updatedMeat));
    }

    @Override
    public void removeMeatFromPurchase(String purchaseId, String meatId) {

        if(!purchaseRepository.existsPurchaseByPurchaseIdentifier_PurchaseId(purchaseId)){
            return;
        }
        Meat meat = meatRepository.findMeatByMeatIdentifier_MeatId(meatId);

        if(meat == null){
            return;
        }
        meatRepository.delete(meat);
    }


    //AGGREGATE GET REQUEST


    @Override
    public PurchaseMeatCustomerButcherModel getPurchaseMeatsCustomersButchers(String purchaseId) {
        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);
        if(purchase == null){
            return null;
        }
        List<Meat> meats = meatRepository.findMeatByPurchaseIdentifier_PurchaseId(purchaseId);
        List<MeatResponseModel> meatResponseModels = meatResponseMapper.entityListToResponseModelList(meats);

        List<Customer>customers = customerRepository.findAllCustomersByPurchaseIdentifier_PurchaseId(purchaseId);
        List<CustomerResponseModel> customerResponseModels = customerResponseMapper.entityListToResponseModelList(customers);

        List<Butcher> butchers = butcherRepository.findButchersByPurchaseIdentifier_PurchaseId(purchaseId);
        List<ButcherResponseModel> butcherResponseModels = butcherResponseMapper.entityListToResponseModelList(butchers);


        return purchaseMeatCustomerButcherMapper.entitiesToResponseModel(purchase, meatResponseModels, customerResponseModels,butcherResponseModels);
    }


}
