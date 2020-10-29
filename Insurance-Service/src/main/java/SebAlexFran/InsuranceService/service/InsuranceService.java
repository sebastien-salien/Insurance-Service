package SebAlexFran.InsuranceService.service;

import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;
}
