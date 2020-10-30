package SebAlexFran.InsuranceService.model;

import SebAlexFran.InsuranceService.Dto.InsuranceDto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
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

    public int contain(Modality cmp){
        for(Modality modality : modalities){
            if(modality.getName().equals(cmp.getName()))
                return modalities.indexOf(modality);
        }
        return -1;
    }

    public List<InsuranceDto> toInsuranceDTO() {
        return modalities.stream()
                .map(val -> InsuranceDto
                        .builder()
                        .id_facilite(id_facility)
                        .name(val.getName())
                        .percentage(val.getPercentage())
                .build())
                .collect(Collectors.toList());
    }

    public String getId_facility() {
        return id_facility;
    }

    public String getId() {
        return id;
    }

    public List<Modality> getModalities() {
        return modalities;
    }
}
