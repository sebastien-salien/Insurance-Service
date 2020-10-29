package SebAlexFran.InsuranceService.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import SebAlexFran.InsuranceService.model.Modality;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "insurance")
public class Insurance {
    @Id
    private String id;
    private String id_facility;
    private List<Modality> modalities;

    public Insurance(String id, String id_facility, List<Modality> modalities) {
        this.id = id;
        this.id_facility = id_facility;
        this.modalities = modalities;
    }
}
