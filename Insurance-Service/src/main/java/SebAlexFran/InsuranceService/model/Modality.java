package SebAlexFran.InsuranceService.model;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Builder
@Getter
public class Modality {
    @Id

    private String name;
    private double percentage;

    public double getPercentage() {
        return percentage;
    }
}
