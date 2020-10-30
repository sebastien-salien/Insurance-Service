package SebAlexFran.InsuranceService.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "insurance")
@ToString
public class DealInsurance {
    @Id
    private String id;
    private String dealCode;
    List<FacilityInsurance> facilities;

    public DealInsurance(String id, String dealCode, List<FacilityInsurance> facilities) {
        this.id = id;
        this.dealCode=dealCode;
        this.facilities=facilities;
    }

    public String getDealCode() {
        return dealCode;
    }

    public String getId() {
        return id;
    }

    public List<FacilityInsurance> getFacilities(){
        return facilities;
    }
}
