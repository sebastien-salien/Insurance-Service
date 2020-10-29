package SebAlexFran.InsuranceService.rest;

import SebAlexFran.InsuranceService.Exception.InsuranceException;
import SebAlexFran.InsuranceService.model.Insurance;
import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import SebAlexFran.InsuranceService.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
    }

    @RequestMapping(path = "/insurance/{id}", method = RequestMethod.GET)
    public String getInsurance(@PathVariable("id") String id) {
        try {
            return this.insuranceService.getInsurance( id );
        } catch (InsuranceException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @RequestMapping(path ="/insurance", method = RequestMethod.GET)
    public String getAllInsurance(){
        return this.insuranceService.getAll().toString();
    }

    @RequestMapping( path = "/insurance/{id}", method = RequestMethod.PUT)
    public String putInsurance(@PathVariable("id") String ins, @RequestBody Insurance body){
        try {
            return this.insuranceService.putInsurance(ins, body);
        } catch (InsuranceException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}

