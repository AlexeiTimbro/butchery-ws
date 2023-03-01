package com.timbro.butcheryws.customermanagementsubdomain.presentationlayer;

import com.timbro.butcheryws.customermanagementsubdomain.businesslayer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<CustomerResponseModel> getCustomers() {
        return customerService.getCustomers();
    }


    @GetMapping("/{customerId}")
    public CustomerResponseModel getCustomerByCustomerId(@PathVariable String customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    @PostMapping()
    public CustomerResponseModel addCustomer(@RequestBody CustomerRequestModel customerRequestModel) {
        return customerService.addCustomer(customerRequestModel);
    }

    @PutMapping("/{customerId}")
    public CustomerResponseModel updateCustomer(@RequestBody CustomerRequestModel customerRequestModel, @PathVariable String customerId) {
        return customerService.updateCustomer(customerRequestModel, customerId);
    }

    @DeleteMapping("/{customerId}")
    public void removeCustomer(@PathVariable String customerId) {
        customerService.removeCustomer(customerId);
    }


}
