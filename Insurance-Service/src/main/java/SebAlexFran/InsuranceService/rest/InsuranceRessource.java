package SebAlexFran.InsuranceService.rest;

import SebAlexFran.InsuranceService.Exception.InsuranceException;
import SebAlexFran.InsuranceService.model.Insurance;
import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import SebAlexFran.InsuranceService.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InsuranceRessource {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(path = "/insurance", method = RequestMethod.POST)
    public String postInsurrance(@RequestBody Insurance insurance) {
        try {
            return insuranceService.postInsurrance(insurance);
        } catch (InsuranceException exception) {
            return "Exception leve " + exception.getMessage();
        }
    }

    @RequestMapping(path = "/insurance/{id}", method = RequestMethod.GET)
    public String getInsurance(@PathVariable("id") Insurance id) {
        try {
            return this.insuranceService.getInsurance( id );
        } catch (InsuranceException exception) {
            return "Exception leve " + exception.getMessage();
        }
    }
}

