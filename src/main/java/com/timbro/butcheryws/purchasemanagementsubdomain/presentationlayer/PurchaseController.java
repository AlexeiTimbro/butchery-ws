package com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.businesslayer.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    //PURCHASE CRUD

    @GetMapping()
    public List<PurchaseResponseModel> getPurchases(){
        return purchaseService.getPurchases();
    }

    @GetMapping("/{purchaseId}")
    public PurchaseResponseModel getPurchaseByPurchaseId(@PathVariable String purchaseId){
        return purchaseService.getPurchaseByPurchaseId(purchaseId);
    }

    @PostMapping()
    public PurchaseResponseModel addPurchase(@RequestBody PurchaseRequestModel purchaseRequestModel){
        return purchaseService.addPurchase(purchaseRequestModel);
    }

    @PutMapping("/{purchaseId}")
    public PurchaseResponseModel updatePurchase(@RequestBody PurchaseRequestModel purchaseRequestModel, @PathVariable String purchaseId){
        return purchaseService.updatePurchase(purchaseRequestModel,purchaseId);
    }

    @DeleteMapping("/{purchaseId}")
    public void removePurchase(@PathVariable String purchaseId){
        purchaseService.removePurchase(purchaseId);
    }

    //CUSTOMER CRUD

    @GetMapping("/{purchaseId}/customers")
    PurchaseCustomerResponseModel getPurchaseCustomer(@PathVariable String purchaseId){
        return purchaseService.getPurchaseCustomers(purchaseId);
    }

    @GetMapping("/{purchaseId}/customers/{customerId}")
    CustomerResponseModel getCustomerInPurchase(@PathVariable String purchaseId, @PathVariable String customerId){
        return purchaseService.getCustomerInPurchaseByCustomerIdentifier_PurchaseId(purchaseId,customerId);
    }

    @PostMapping("/{purchaseId}/customers")
    CustomerResponseModel addCustomerToPurchase(@RequestBody CustomerRequestModel customerRequestModel, @PathVariable String purchaseId){
        return purchaseService.addCustomerToPurchase(customerRequestModel, purchaseId);
    }

    @PutMapping("/{purchaseId}/customers/{customerId}")
    public CustomerResponseModel updateCustomerInPurchase(@RequestBody CustomerRequestModel customerRequestModel, @PathVariable String purchaseId, @PathVariable String customerId){
        return purchaseService.updateCustomerInPurchase(customerRequestModel, purchaseId, customerId);
    }

    @DeleteMapping("{purchaseId}/customers/{customerId}")
    public void removeCustomerFromPurchase(@PathVariable String purchaseId, @PathVariable String customerId){
        purchaseService.removeCustomerFromPurchase(purchaseId, customerId);
    }

}
