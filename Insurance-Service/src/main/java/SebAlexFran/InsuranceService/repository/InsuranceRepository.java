package SebAlexFran.InsuranceService.repository;

import SebAlexFran.InsuranceService.model.DealInsurance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface InsuranceRepository extends MongoRepository<DealInsurance, String> {
     DealInsurance findByDealCode(String dealCode);
}
