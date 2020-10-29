package SebAlexFran.InsuranceService.rest;

import SebAlexFran.InsuranceService.model.Insurance;
import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import SebAlexFran.InsuranceService.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class InsuranceRessource {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(path = "/insurance" , method = RequestMethod.POST)
    public String postInsurrance(@RequestBody Insurance insurance) {
        try{
            return insuranceService.postInsurrance(insurance);
        } catch (InsurranceException exception){
            return "Exception leve "+exception.getMessage();
        }
    }

    @RequestMapping( path="/insurance", method= RequestMethod.GET)
    public String getInsurance(){
        this.insuranceRepository.save(new Insurance("efyzici","fcckc", new ArrayList<Modality>()));

        return "hvj;bv";
    }

}
