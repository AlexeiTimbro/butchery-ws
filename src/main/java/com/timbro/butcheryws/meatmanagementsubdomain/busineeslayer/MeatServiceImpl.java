package com.timbro.butcheryws.meatmanagementsubdomain.busineeslayer;

import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Address;
import com.timbro.butcheryws.customermanagementsubdomain.datalayer.Customer;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.Meat;
import com.timbro.butcheryws.meatmanagementsubdomain.datalayer.MeatRepository;
import com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer.MeatRequestMapper;
import com.timbro.butcheryws.meatmanagementsubdomain.datamapperlayer.MeatResponseMapper;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeatServiceImpl implements MeatService {

    private MeatRepository meatRepository;
    private MeatRequestMapper meatRequestMapper;
    private MeatResponseMapper meatResponseMapper;

    public MeatServiceImpl(MeatRepository meatRepository, MeatRequestMapper meatRequestMapper, MeatResponseMapper meatResponseMapper) {
        this.meatRepository = meatRepository;
        this.meatRequestMapper = meatRequestMapper;
        this.meatResponseMapper = meatResponseMapper;
    }

    @Override
    public List<MeatResponseModel> getMeats() {
        return meatResponseMapper.entityListToResponseModelList(meatRepository.findAll());
    }

    @Override
    public MeatResponseModel getMeatByMeatId(String meatId) {
        return meatResponseMapper.entityToResponseModel(meatRepository.findByMeatIdentifier_MeatId(meatId));
    }

    @Override
    public MeatResponseModel addMeat(MeatRequestModel meatRequestModel) {
        Meat meat = meatRequestMapper.requestModelToEntity(meatRequestModel);

        return meatResponseMapper.entityToResponseModel(meatRepository.save(meat));
    }

    @Override
    public MeatResponseModel updateMeat(MeatRequestModel meatRequestModel, String meatId) {
        Meat existingMeat = meatRepository.findByMeatIdentifier_MeatId(meatId);

        if (existingMeat == null) {
            return null; //later throw exception
        }

        Meat meat = meatRequestMapper.requestModelToEntity(meatRequestModel);
        meat.setId(existingMeat.getId());
        meat.setMeatIdentifier(existingMeat.getMeatIdentifier());

        return meatResponseMapper.entityToResponseModel(meatRepository.save(meat));
    }

    @Override
    public void removeMeat(String meatId) {

        Meat existingMeat = meatRepository.findByMeatIdentifier_MeatId(meatId);

        if (existingMeat == null) {
            return; //later throw exception
        }
        meatRepository.delete(existingMeat);
    }
}
