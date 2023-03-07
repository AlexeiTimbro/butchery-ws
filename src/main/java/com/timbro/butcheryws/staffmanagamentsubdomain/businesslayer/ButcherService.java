package com.timbro.butcheryws.staffmanagamentsubdomain.businesslayer;

import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherRequestModel;
import com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer.ButcherResponseModel;

import java.util.List;

public interface ButcherService {

    List<ButcherResponseModel> getButchers();
    ButcherResponseModel getButcherByButcherId(String butcherId);
    ButcherResponseModel addButcher(ButcherRequestModel butcherRequestModel, String purchaseId);
    ButcherResponseModel updateButcher(ButcherRequestModel butcherRequestModel, String butcherId);
    void removeButcher(String butcherId);
}
