package SebAlexFran.InsuranceService.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data

public class Insurance {
    @Id
    @GeneratedValue
    private String id;
    private String id_facility;

}
