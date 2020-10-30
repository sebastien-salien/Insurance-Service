package SebAlexFran.InsuranceService.rest;


import SebAlexFran.InsuranceService.Exception.InsuranceException;
import SebAlexFran.InsuranceService.model.DealInsurance;

import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import SebAlexFran.InsuranceService.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InsuranceRessource {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(path = "/insurance", method = RequestMethod.POST)
    public DealInsurance postInsurrance(@RequestBody DealInsurance insurance) {
        try {
            return insuranceService.postInsurrance(insurance);
        } catch (InsuranceException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
    }

    @RequestMapping(path = "/insurance/{dealCode}", method = RequestMethod.GET)
    public DealInsurance getInsurance(@PathVariable("dealCode") String dealCode) {
        try {
            return this.insuranceService.getInsurance( dealCode );
        } catch (InsuranceException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @RequestMapping(path ="/insurance", method = RequestMethod.GET)
    public List<DealInsurance> getAllInsurance(){
        return this.insuranceService.getAll();
    }

    @RequestMapping( path = "/insurance/{dealCode}/{idFacility}", method = RequestMethod.PUT)
    public DealInsurance putInsurance(@PathVariable("dealCode") String dealCode, @PathVariable("idFacility") String idFacility,@RequestBody List<Modality> modalities){
        try {
            return this.insuranceService.putInsurance(dealCode, idFacility, modalities);
        } catch (InsuranceException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @RequestMapping(path = "/insurance/{dealCode}", method = RequestMethod.DELETE)
    public void deleteInsurance(@PathVariable("dealCode") String dealCode){
        try{
            this.insuranceService.deleteInsurance(dealCode);
        }catch (InsuranceException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}

