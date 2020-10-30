package SebAlexFran.InsuranceService.model;

import java.util.List;

public class FacilityInsurance {
    private String id_facility;
    private List<Modality> modalities;

    public FacilityInsurance(String id_facility, List<Modality> modalities){
        this.id_facility=id_facility;
        this.modalities=modalities;
    }

    public int contain(Modality cmp){
        for(Modality modality : modalities){
            if(modality.getName().equals(cmp.getName()))
                return modalities.indexOf(modality);
        }
        return -1;
    }

    public List<Modality> getModalities() {
        return modalities;
    }
    public String getId_facility(){return id_facility;}
}
