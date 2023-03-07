package com.timbro.butcheryws.customermanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerIdentifier;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerRepository;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerRequestMapper;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerResponseMapper;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseRepository;
import com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer.PurchaseRequestMapper;
import com.timbro.butcheryws.purchasemanagementsubdomain.datamapperlayer.PurchaseResponseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private CustomerResponseMapper customerResponseMapper;
    private CustomerRequestMapper customerRequestMapper;

    private PurchaseRepository purchaseRepository;
    private PurchaseRequestMapper purchaseRequestMapper;
    private PurchaseResponseMapper purchaseResponseMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper, CustomerRequestMapper customerRequestMapper, PurchaseRepository purchaseRepository, PurchaseRequestMapper purchaseRequestMapper, PurchaseResponseMapper purchaseResponseMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
        this.purchaseRepository = purchaseRepository;
        this.purchaseRequestMapper = purchaseRequestMapper;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        return customerResponseMapper.entityListToResponseModelList(customerRepository.findAll());
    }

    @Override
    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        return customerResponseMapper.entityToResponseModel(customerRepository.findByCustomerIdentifier_CustomerId(customerId));
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel, String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);

        if(purchase == null){
            return null;
        }
        CustomerIdentifier customerIdentifier = new CustomerIdentifier(customerRequestModel.getCustomerId());

        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel,customerIdentifier,purchase.getPurchaseIdentifier());

        Customer saved = customerRepository.save(customer);

        return customerResponseMapper.entityToResponseModel(saved);


    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (existingCustomer == null) {
            return null; //later throw exception
        }
        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel, existingCustomer.getCustomerIdentifier(),existingCustomer.getPurchaseIdentifier());



        customer.setId(existingCustomer.getId());
        customer.setCustomerIdentifier(existingCustomer.getCustomerIdentifier());

        return customerResponseMapper.entityToResponseModel(customerRepository.save(customer));
    }

    @Override
    public void removeCustomer(String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (existingCustomer == null) {
            return; //later throw exception
        }
        customerRepository.delete(existingCustomer);
    }
}
