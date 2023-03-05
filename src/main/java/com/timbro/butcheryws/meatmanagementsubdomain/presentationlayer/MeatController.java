package com.timbro.butcheryws.meatmanagementsubdomain.presentationlayer;

import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.timbro.butcheryws.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.timbro.butcheryws.meatmanagementsubdomain.busineeslayer.MeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/meats")
public class MeatController {

    private MeatService meatService;

    public MeatController(MeatService meatService) {
        this.meatService = meatService;
    }

    @GetMapping()
    public List<MeatResponseModel> getMeats() {
        return meatService.getMeats();
    }


    @GetMapping("/{meatId}")
    public MeatResponseModel getMeatByMeatId(@PathVariable String meatId) {
        return meatService.getMeatByMeatId(meatId);
    }

    @PostMapping()
    public MeatResponseModel addMeat(@RequestBody MeatRequestModel meatRequestModel) {
        return meatService.addMeat(meatRequestModel);
    }

    @PutMapping("/{meatId}")
    public MeatResponseModel updateMeat(@RequestBody MeatRequestModel meatRequestModel, @PathVariable String meatId) {
        return meatService.updateMeat(meatRequestModel,meatId);
    }

    @DeleteMapping("/{meatId}")
    public void removeMeat(@PathVariable String meatId) {
        meatService.removeMeat(meatId);
    }
}
