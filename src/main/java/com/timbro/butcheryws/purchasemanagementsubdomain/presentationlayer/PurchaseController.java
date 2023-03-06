package com.timbro.butcheryws.purchasemanagementsubdomain.presentationlayer;

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
}
