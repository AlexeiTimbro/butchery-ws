package com.timbro.butcheryws.meatmanagementsubdomain.busineeslayer;

import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.Meat;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.MeatIdentifier;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.MeatRepository;
import com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer.MeatRequestMapper;
import com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer.MeatResponseMapper;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.Purchase;
import com.timbro.butcheryws.purchasemanagementsubdomain.datalayer.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeatServiceImpl implements MeatService {

    private MeatRepository meatRepository;
    private MeatRequestMapper meatRequestMapper;
    private MeatResponseMapper meatResponseMapper;
    private PurchaseRepository purchaseRepository;

    public MeatServiceImpl(MeatRepository meatRepository, MeatRequestMapper meatRequestMapper, MeatResponseMapper meatResponseMapper, PurchaseRepository purchaseRepository) {
        this.meatRepository = meatRepository;
        this.meatRequestMapper = meatRequestMapper;
        this.meatResponseMapper = meatResponseMapper;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<MeatResponseModel> getMeats() {
        return meatResponseMapper.entityListToResponseModelList(meatRepository.findAll());
    }

    @Override
    public MeatResponseModel getMeatByMeatId(String meatId) {
        return meatResponseMapper.entityToResponseModel(meatRepository.findMeatByMeatIdentifier_MeatId(meatId));
    }

    @Override
    public MeatResponseModel addMeat(MeatRequestModel meatRequestModel,  String purchaseId) {

        Purchase purchase = purchaseRepository.findByPurchaseIdentifier_PurchaseId(purchaseId);

        if(purchase == null){
            return null;
        }
        MeatIdentifier meatIdentifier = new MeatIdentifier(meatRequestModel.getMeatId());

        Meat meat = meatRequestMapper.requestModelToEntity(meatRequestModel,meatIdentifier,purchase.getPurchaseIdentifier());
        Meat saved = meatRepository.save(meat);

        return meatResponseMapper.entityToResponseModel(saved);
    }

    @Override
    public MeatResponseModel updateMeat(MeatRequestModel meatRequestModel, String meatId) {
        Meat existingMeat = meatRepository.findMeatByMeatIdentifier_MeatId(meatId);

        if (existingMeat == null) {
            return null; //later throw exception
        }

        Meat meat = meatRequestMapper.requestModelToEntity(meatRequestModel,existingMeat.getMeatIdentifier(),existingMeat.getPurchaseIdentifier());
        meat.setId(existingMeat.getId());

        return meatResponseMapper.entityToResponseModel(meatRepository.save(meat));
    }

    @Override
    public void removeMeat(String meatId) {

        Meat existingMeat = meatRepository.findMeatByMeatIdentifier_MeatId(meatId);

        if (existingMeat == null) {
            return; //later throw exception
        }
        meatRepository.delete(existingMeat);
    }
}
