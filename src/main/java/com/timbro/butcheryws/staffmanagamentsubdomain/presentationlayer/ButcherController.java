package com.timbro.butcheryws.staffmanagamentsubdomain.presentationlayer;


import com.timbro.butcheryws.staffmanagamentsubdomain.businesslayer.ButcherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/butchers")
public class ButcherController {

    private ButcherService butcherService;

    public ButcherController(ButcherService butcherService) {
        this.butcherService = butcherService;
    }

    @GetMapping()
    public List<ButcherResponseModel> getButchers() {
        return butcherService.getButchers();
    }


    @GetMapping("/{butcherId}")
    public ButcherResponseModel getButcherByButcherId(@PathVariable String butcherId) {
        return butcherService.getButcherByButcherId(butcherId);
    }

    @PostMapping("/purchaseId")
    public ButcherResponseModel addButcher(@RequestBody ButcherRequestModel butcherRequestModel, @PathVariable String purchaseId) {
        return butcherService.addButcher(butcherRequestModel, purchaseId);
    }

    @PutMapping("/{butcherId}")
    public ButcherResponseModel updateButcher(@RequestBody ButcherRequestModel butcherRequestModel, @PathVariable String butcherId) {
        return butcherService.updateButcher(butcherRequestModel, butcherId);
    }

    @DeleteMapping("/{butcherId}")
    public void removeButcher(@PathVariable String butcherId) {
        butcherService.removeButcher(butcherId);
    }
}
