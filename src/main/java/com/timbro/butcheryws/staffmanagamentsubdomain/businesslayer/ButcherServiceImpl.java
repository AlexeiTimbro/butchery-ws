package com.timbro.butcheryws.staffmanagamentsubdomain.businesslayer;


import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseRepository;
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
public class ButcherServiceImpl implements ButcherService{


    private ButcherRepository butcherRepository;
    private ButcherResponseMapper butcherResponseMapper;
    private ButcherRequestMapper butcherRequestMapper;
    private PurchaseRepository purchaseRepository;

    public ButcherServiceImpl(ButcherRepository butcherRepository, ButcherResponseMapper butcherResponseMapper, ButcherRequestMapper butcherRequestMapper, PurchaseRepository purchaseRepository) {
        this.butcherRepository = butcherRepository;
        this.butcherResponseMapper = butcherResponseMapper;
        this.butcherRequestMapper = butcherRequestMapper;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<ButcherResponseModel> getButchers() {

        return butcherResponseMapper.entityListToResponseModelList(butcherRepository.findAll());
    }

    @Override
    public ButcherResponseModel getButcherByButcherId(String butcherId) {

        return butcherResponseMapper.entityToResponseModel(butcherRepository.findButcherByButcherIdentifier_ButcherId(butcherId));
    }

    @Override
    public ButcherResponseModel addButcher(ButcherRequestModel butcherRequestModel, String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);

        if(purchase == null){
            return null;
        }
        ButcherIdentifier butcherIdentifier = new ButcherIdentifier((butcherRequestModel.getButcherId()));

        Butcher butcher = butcherRequestMapper.requestModelToEntity(butcherRequestModel,butcherIdentifier,purchase.getPurchaseIdentifier());
        Butcher saved = butcherRepository.save(butcher);

        return butcherResponseMapper.entityToResponseModel(saved);
    }

    @Override
    public ButcherResponseModel updateButcher(ButcherRequestModel butcherRequestModel, String butcherId) {

        Butcher existingButcher = butcherRepository.findButcherByButcherIdentifier_ButcherId(butcherId);
        if (existingButcher == null) {
            return null; //later throw exception
        }

        Butcher butcher = butcherRequestMapper.requestModelToEntity(butcherRequestModel,existingButcher.getButcherIdentifier(),existingButcher.getPurchaseIdentifier());
        butcher.setId(existingButcher.getId());

        return butcherResponseMapper.entityToResponseModel(butcherRepository.save(butcher));
    }

    @Override
    public void removeButcher(String butcherId) {

        Butcher existingButcher = butcherRepository.findButcherByButcherIdentifier_ButcherId(butcherId);
        if (existingButcher == null) {
            return; //later throw exception
        }

        butcherRepository.delete(existingButcher);

    }
}
