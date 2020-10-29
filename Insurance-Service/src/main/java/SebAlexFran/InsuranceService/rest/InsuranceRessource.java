package SebAlexFran.InsuranceService.rest;

import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import SebAlexFran.InsuranceService.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuranceRessource {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private InsuranceService insuranceService;

}
