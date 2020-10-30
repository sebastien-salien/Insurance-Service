package SebAlexFran.InsuranceService.service;


import SebAlexFran.InsuranceService.Exception.InsuranceException;
import SebAlexFran.InsuranceService.model.DealInsurance;

import SebAlexFran.InsuranceService.model.FacilityInsurance;
import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public DealInsurance postInsurrance(DealInsurance dealInsurance) throws InsuranceException {
        if(dealInsurance==null) throw new InsuranceException("pas de deal");

        return insuranceRepository.save(dealInsurance);
    }

    public List<DealInsurance> getAll(){
        return insuranceRepository.findAll();
    }

    public DealInsurance getInsurance(String dealCode) throws InsuranceException {
        if(dealCode.isEmpty()) throw new InsuranceException("pas de deal code");
        return insuranceRepository.findByDealCode(dealCode);
    }

    public DealInsurance putInsurance(String dealCode, String facilityId, List<Modality> modalities) throws InsuranceException {
        if(dealCode.isEmpty()) throw  new InsuranceException("pas de deal code");
        if(facilityId.isEmpty()) throw new InsuranceException("pas de facilité id");
        DealInsurance dealInsurance = getInsurance(dealCode);
        FacilityInsurance facilityInsurance = dealInsurance.getFacilities()
                .stream()
                .filter( f -> f.getId_facility().equals(facilityId))
                .findAny()
                .get();

        modalities.stream().map(m -> facilityInsurance.getModalities().add(m));

        return insuranceRepository.save(dealInsurance);
    }

    public void deleteInsurance(String dealCode) throws InsuranceException {
        if(dealCode.isEmpty()) throw  new InsuranceException("pas de deal code");
        DealInsurance dealInsurance = getInsurance(dealCode);
        insuranceRepository.delete(dealInsurance);
    }
}
