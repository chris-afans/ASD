package edu.miu.cs.cs489.lab6.service;

import edu.miu.cs.cs489.lab6.model.Dentist;
import edu.miu.cs.cs489.lab6.repository.DentistRepository;
import org.springframework.stereotype.Service;

@Service
public class DentistService {

    private DentistRepository dentistRepository;

    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist addDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public Dentist getDentist(Integer id) {
        return dentistRepository.findById(id).orElse(null);
    }

    public Dentist updateDentist(Dentist dentist){
        return dentistRepository.save(dentist);
    }

    public void deleteDentists(Integer id){
        dentistRepository.deleteById(id);
    }

}
