package SebAlexFran.InsuranceService.service;

import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public String postInsurrance(Insurance ins) throws InsurranceException{
        if(ins.getId().isEmpty())
            throw new InsurranceException("Insurance id is Empty");
        if(ins.getId_facility().isEmpty())
            throw new InsurranceException("Facility id is Empty");
        for(Modality modal : ins.getModalities()){
            if(modal.getPercentage() <= 0.0)
                throw new InsurranceException("Pourcentage nul");
        }
        return insuranceRepository.save(ins).toString();
    }
}
