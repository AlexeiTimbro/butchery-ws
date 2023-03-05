package com.timbro.butcheryws.meatmanagementsubdomain.busineeslayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatRequestModel;
import com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer.MeatResponseModel;

import java.util.List;

public interface MeatService {

    List<MeatResponseModel> getMeats();

    MeatResponseModel getMeatByMeatId(String meatId);

    MeatResponseModel addMeat(MeatRequestModel meatRequestModel);

    MeatResponseModel updateMeat(MeatRequestModel meatRequestModel, String meatId);

    void removeMeat(String meatId);
}
