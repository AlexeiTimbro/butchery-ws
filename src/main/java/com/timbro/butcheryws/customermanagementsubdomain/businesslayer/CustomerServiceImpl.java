package com.timbro.butcheryws.customermanagementsubdomain.businesslayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Address;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.CustomerRepository;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerRequestMapper;
import com.timbro.butcheryws.customermanagementsubdomain.datamapperlayer.CustomerResponseMapper;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private CustomerResponseMapper customerResponseMapper;
    private CustomerRequestMapper customerRequestMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper, CustomerRequestMapper customerRequestMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
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
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {

        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
                customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());
        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel);
        customer.setAddress(address);

        return customerResponseMapper.entityToResponseModel(customerRepository.save(customer));


    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (existingCustomer == null) {
            return null; //later throw exception
        }

        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
                customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());
        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel);
        customer.setAddress(address);


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
