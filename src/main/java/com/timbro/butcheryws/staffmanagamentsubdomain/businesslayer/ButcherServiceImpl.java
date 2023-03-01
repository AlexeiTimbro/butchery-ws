package com.timbro.butcheryws.staffmanagamentsubdomain.businesslayer;


import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Address;
import com.timbro.butcheryws.staffmanagamentsubdomain.datalayer.Butcher;
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

    public ButcherServiceImpl(ButcherRepository butcherRepository, ButcherResponseMapper butcherResponseMapper, ButcherRequestMapper butcherRequestMapper) {
        this.butcherRepository = butcherRepository;
        this.butcherResponseMapper = butcherResponseMapper;
        this.butcherRequestMapper = butcherRequestMapper;
    }

    @Override
    public List<ButcherResponseModel> getButchers() {

        return butcherResponseMapper.entityListToResponseModelList(butcherRepository.findAll());
    }

    @Override
    public ButcherResponseModel getButcherByButcherId(String butcherId) {

        return butcherResponseMapper.entityToResponseModel(butcherRepository.findByButcherIdentifier_ButcherId(butcherId));
    }

    @Override
    public ButcherResponseModel addButcher(ButcherRequestModel butcherRequestModel) {

        Address address = new Address(butcherRequestModel.getStreetAddress(), butcherRequestModel.getCity(),
                butcherRequestModel.getProvince(), butcherRequestModel.getCountry(), butcherRequestModel.getPostalCode());

        Butcher butcher = butcherRequestMapper.requestModelToEntity(butcherRequestModel);
        butcher.setAddress(address);

        return butcherResponseMapper.entityToResponseModel(butcherRepository.save(butcher));
    }

    @Override
    public ButcherResponseModel updateButcher(ButcherRequestModel butcherRequestModel, String butcherId) {

        Butcher existingButcher = butcherRepository.findByButcherIdentifier_ButcherId(butcherId);
        if (existingButcher == null) {
            return null; //later throw exception
        }

        Address address = new Address(butcherRequestModel.getStreetAddress(), butcherRequestModel.getCity(),
                butcherRequestModel.getProvince(), butcherRequestModel.getCountry(), butcherRequestModel.getPostalCode());

        Butcher butcher = butcherRequestMapper.requestModelToEntity(butcherRequestModel);
        butcher.setAddress(address);

        butcher.setId(existingButcher.getId());
        butcher.setButcherIdentifier(existingButcher.getButcherIdentifier());

        return butcherResponseMapper.entityToResponseModel(butcherRepository.save(butcher));
    }

    @Override
    public void removeButcher(String butcherId) {

        Butcher existingButcher = butcherRepository.findByButcherIdentifier_ButcherId(butcherId);
        if (existingButcher == null) {
            return; //later throw exception
        }

        butcherRepository.delete(existingButcher);

    }
}
