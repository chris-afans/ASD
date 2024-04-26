package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;
import edu.miu.cs.cs489.adsmgtcliapp.model.Dentist;
import edu.miu.cs.cs489.adsmgtcliapp.model.DentistDTO;
import edu.miu.cs.cs489.adsmgtcliapp.repository.DentistRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.DentistInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService implements DentistInterface {


    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DentistService() {

    }

    @Override
    public DentistDTO addDentist(Dentist dentist) {
        dentistRepository.save(dentist);
        return modelMapper.map(dentist, DentistDTO.class);
    }

    @Override
    public List<DentistDTO> getAllDentists() {
        return dentistRepository.findAll().stream()
                .map((d) -> modelMapper.map(d, DentistDTO.class)).toList();
    }

    @Override
    public DentistDTO getDentist(Integer id) throws DentistNotFoundException {

        var dentist = dentistRepository.findById(id).orElse(null);
        if(dentist != null){
            return modelMapper.map(dentist, DentistDTO.class);
        }else{
            throw new DentistNotFoundException("Dentist with id: " + id + "not found");
        }
    }

    @Override
    public DentistDTO updateDentist(Integer id, Dentist dentist) throws DentistNotFoundException {
        var foundDentist = dentistRepository.findById(id).orElse(null);
        if(foundDentist != null){
            foundDentist = dentist;
            dentistRepository.save(foundDentist);
            return modelMapper.map(foundDentist, DentistDTO.class);
        }else{
            throw new DentistNotFoundException("Dentist with id: " + id + "not found");
        }
    }

    @Override
    public void deleteDentist(Integer id){
        dentistRepository.deleteById(id);
    }

}
