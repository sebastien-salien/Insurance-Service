package SebAlexFran.InsuranceService.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;
import SebAlexFran.InsuranceService.model.Modality;

@Entity
@Data

public class Insurance {
    @Id
    @GeneratedValue
    private String id;
    private String id_facility;
    @OneToMany
    private List<Modality> modalities;

}
