package SebAlexFran.InsuranceService.model;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;


@Builder
@Getter
public class Modality {
    @Id
    private String name;
    private double percentage;

    public double getPercentage() {
        return percentage;
    }

    @Override
    public boolean equals(Object other){
        if(((Modality) other).getName() == name)
            return true;
        return false;
    }
}
