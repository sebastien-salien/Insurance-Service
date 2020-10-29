package SebAlexFran.InsuranceService.repository;

import SebAlexFran.InsuranceService.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
