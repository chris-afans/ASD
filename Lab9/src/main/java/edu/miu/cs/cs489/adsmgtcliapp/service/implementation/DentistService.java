package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;
import edu.miu.cs.cs489.adsmgtcliapp.model.Dentist;
import edu.miu.cs.cs489.adsmgtcliapp.repository.DentistRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.DentistInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService implements DentistInterface {


    private DentistRepository dentistRepository;

    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist addDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist getDentist(Integer id) throws DentistNotFoundException {

        var dentist = dentistRepository.findById(id).orElse(null);
        if(dentist != null){
            return dentist;
        }else{
            throw new DentistNotFoundException("Dentist with id: " + id + "not found");
        }
    }

    @Override
    public Dentist updateDentist(Integer id, Dentist dentist) throws DentistNotFoundException {
        var foundDentist = dentistRepository.findById(id).orElse(null);
        if(foundDentist != null){
            foundDentist = dentist;
            dentistRepository.save(foundDentist);
            return foundDentist;
        }else{
            throw new DentistNotFoundException("Dentist with id: " + id + "not found");
        }
    }

    @Override
    public void deleteDentist(Integer id){
        dentistRepository.deleteById(id);
    }

}
