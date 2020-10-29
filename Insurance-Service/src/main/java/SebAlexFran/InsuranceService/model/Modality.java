package SebAlexFran.InsuranceService.model;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Getter
public class Modality {
    @Id
    @GeneratedValue

    private String name;
    private String percentage;
}
