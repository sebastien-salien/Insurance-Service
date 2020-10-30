package SebAlexFran.InsuranceService.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceDto {
    private String id_facilite;
    private String name;
    private double percentage;
}
