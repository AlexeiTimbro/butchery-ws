package com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.businesslayer.PurchaseService;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;
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


    //BUTCHER CRUD

    @GetMapping("/{purchaseId}/butchers")
    PurchaseButcherResponseModel getPurchaseButcher(@PathVariable String purchaseId){
        return purchaseService.getPurchaseButchers(purchaseId);
    }

    @GetMapping("/{purchaseId}/butchers/{butcherId}")
    ButcherResponseModel getButcherInPurchase(@PathVariable String purchaseId, @PathVariable String butcherId){
        return purchaseService.getButcherInPurchase(purchaseId,butcherId);
    }


    @PostMapping("/{purchaseId}/butchers")
    ButcherResponseModel addButcherToLesson(@RequestBody ButcherRequestModel butcherRequestModel, @PathVariable String purchaseId){
        return purchaseService.addButcherToPurchase(butcherRequestModel,purchaseId);
    }


    @PutMapping("/{purchaseId}/butchers/{butcherId}")
    public ButcherResponseModel updateButcherInPurchase(@RequestBody ButcherRequestModel butcherRequestModel, @PathVariable String purchaseId, @PathVariable String butcherId){
        return purchaseService.updateButcherInPurchase(butcherRequestModel,purchaseId,butcherId);
    }

    @DeleteMapping("{purchaseId}/butchers/{butcherId}")
    public void removeButcherFromPurchase(@PathVariable String purchaseId, @PathVariable String butcherId){
        purchaseService.removeButcherFromPurchase(purchaseId,butcherId);
    }


    //MEAT CRUD

    @GetMapping("/{purchaseId}/meats")
    PurchaseMeatResponseModel getPurchaseMeat(@PathVariable String purchaseId){
        return purchaseService.getPurchaseMeats(purchaseId);
    }

    @GetMapping("/{purchaseId}/meats/{meatId}")
    MeatResponseModel getMeatInPurchase(@PathVariable String purchaseId, @PathVariable String meatId){
        return purchaseService.getMeatInPurchase(purchaseId,meatId);
    }

    @PostMapping("/{purchaseId}/meats")
    MeatResponseModel addMeatToLesson(@RequestBody MeatRequestModel meatRequestModel, @PathVariable String purchaseId){
        return purchaseService.addMeatToPurchase(meatRequestModel,purchaseId);
    }

    @PutMapping("/{purchaseId}/meats/{meatId}")
    public MeatResponseModel updateMeatInPurchase(@RequestBody MeatRequestModel meatRequestModel, @PathVariable String purchaseId, @PathVariable String meatId){
        return purchaseService.updateMeatInPurchase(meatRequestModel,purchaseId,meatId);
    }

    @DeleteMapping("{purchaseId}/meats/{meatId}")
    public void removeMeatFromPurchase(@PathVariable String purchaseId, @PathVariable String meatId){
        purchaseService.removeMeatFromPurchase(purchaseId,meatId);
    }

    //AGGREGATE GET REQUEST
    @GetMapping("/{purchaseId}/meats/customers/butchers")
    PurchaseMeatCustomerButcherModel getPurchaseMeatCustomerButcher(@PathVariable String purchaseId){
        return purchaseService.getPurchaseMeatsCustomersButchers(purchaseId);
    }

}
