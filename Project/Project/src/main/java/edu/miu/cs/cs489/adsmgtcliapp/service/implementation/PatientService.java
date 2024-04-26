package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.repository.PatientRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.PatientServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PatientService implements PatientServiceInterface {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public PatientService() {

    }

    @Override
    public PatientDTO addPatient(Patient patient) {
        patientRepository.save(patient);
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public PatientDTO searchPatientById(Integer patientId) throws PatientNotFoundException {
        Patient p = patientRepository.findById(patientId).orElse(null);
        if(p != null){
            return modelMapper.map(p, PatientDTO.class);
        }else{
            throw new PatientNotFoundException("Patient with id: " + patientId + "not found");
        }
    }

    @Override
    public PatientDTO searchPatientByLastName(String name) throws PatientNotFoundException {
        var p = patientRepository.findByLastName(name);
        if(p != null){
            return modelMapper.map(p, PatientDTO.class);
        }else{
            throw new PatientNotFoundException("Patient not found");
        }
    }

    public List<PatientDTO> getPatientList(){
        var patientList = patientRepository.findAll().stream()
                .map((p) -> modelMapper.map(p, PatientDTO.class))
                .sorted(Comparator.comparing(PatientDTO::getLastName)).toList();
        return patientList;
    }

    @Override
    public void deletePatient(Integer patientId){
        patientRepository.deleteById(patientId);
    }

    @Override
    public PatientDTO updatePatient(Integer patientId,Patient patient) throws PatientNotFoundException {
        var foundPatient = patientRepository.findById(patientId).orElse(null);
        if(foundPatient != null){
            foundPatient = patient;
            patientRepository.save(foundPatient);
            return modelMapper.map(foundPatient, PatientDTO.class);
        }else{
            throw new PatientNotFoundException("Patient with id: " + patientId + "not found");
        }
    }
}
