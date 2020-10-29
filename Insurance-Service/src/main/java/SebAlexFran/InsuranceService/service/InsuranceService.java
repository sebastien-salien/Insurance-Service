package SebAlexFran.InsuranceService.service;

import SebAlexFran.InsuranceService.Exception.InsuranceException;
import SebAlexFran.InsuranceService.model.Insurance;
import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public String postInsurrance(Insurance ins) throws InsuranceException {
        if(ins.getId().isEmpty())
            throw new InsuranceException("Insurance id is Empty");
        if(ins.getId_facility().isEmpty())
            throw new InsuranceException("Facility id is Empty");
        for(Modality modal : ins.getModalities()){
            if(modal.getPercentage() <= 0.0)
                throw new InsuranceException("Pourcentage nul");
        }
        return insuranceRepository.save(ins).toString();
    }

    public String getInsurance(Insurance ins) throws InsuranceException {
        Optional<Insurance> opt = insuranceRepository.findById(ins.getId());
        System.out.println(ins);
        if(!opt.isPresent()) return "id non existant";
        return opt.get().toString();
    }

    public String putInsurance(String id, Insurance body) throws InsuranceException {
        Optional<Insurance> opt = insuranceRepository.findById(id);
        if(opt.isEmpty())
            throw new InsuranceException("Insurance null");
        return opt.get().toString();
    }
}
