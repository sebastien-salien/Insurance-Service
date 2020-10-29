package SebAlexFran.InsuranceService.service;

import SebAlexFran.InsuranceService.Exception.InsuranceException;
import SebAlexFran.InsuranceService.model.Insurance;
import SebAlexFran.InsuranceService.model.Modality;
import SebAlexFran.InsuranceService.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public String postInsurrance(Insurance ins) throws InsuranceException {
        if (ins.getId().isEmpty())
            throw new InsuranceException("Insurance id is Empty");
        if (ins.getId_facility().isEmpty())
            throw new InsuranceException("Facility id is Empty");
        if (!insuranceRepository.findById(ins.getId()).isPresent()) {
            Optional<Insurance> opt = insuranceRepository.findById(ins.getId());
            for (Modality modal : ins.getModalities()) {
                if (modal.getPercentage() <= 0.0)
                    throw new InsuranceException("Pourcentage nul");
            }
            return insuranceRepository.save(ins).toString();
        }
        throw new InsuranceException("Insurance id deja existant");
    }

    public List<Insurance> getAll(){
        return insuranceRepository.findAll();
    }

    public String getInsurance(String ins) throws InsuranceException {
        Optional<Insurance> opt = insuranceRepository.findById(ins);
        if(!opt.isPresent()) throw new InsuranceException("id non existant");
        return opt.get().toString();
    }

    public String putInsurance(String id, Insurance body) throws InsuranceException {
        if(id=="")
            throw new InsuranceException("Insurance id null");
        if(body==null)
            throw new InsuranceException("Insurance null");
        Optional<Insurance> opt = insuranceRepository.findById(id);
        if(opt.isEmpty())
            throw new InsuranceException("Insurance null");
        String newFid;
        if(body.getId_facility()!=null)
            newFid = body.getId_facility();
        else
            newFid = opt.get().getId_facility();
        int index;
        if((body.getModalities()!=opt.get().getModalities()) && (body.getModalities()!=null))
            for(Modality elt : body.getModalities()){
                if (elt.getPercentage()<=0.0)
                    throw new InsuranceException("pourcentage assurance nul");
                index = opt.get().contain(elt);
                if (index == -1)
                    opt.get().getModalities().add(elt);
                else {
                    double tmp= opt.get().getModalities().get(index).getPercentage();
                    if (tmp != elt.getPercentage()){
                        opt.get().getModalities().remove(index);
                        opt.get().getModalities().add(elt);
                    }
                    else
                        throw new InsuranceException("assurance deja existant");
                }}
        Insurance newIns = new Insurance(id, newFid, opt.get().getModalities());
        return insuranceRepository.save(newIns).toString();
    }
}
