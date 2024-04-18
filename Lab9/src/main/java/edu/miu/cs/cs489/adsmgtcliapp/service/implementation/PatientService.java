package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.repository.PatientRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.PatientServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PatientService implements PatientServiceInterface {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient searchPatientById(Integer patientId) throws PatientNotFoundException {
        Patient p = patientRepository.findById(patientId).orElse(null);
        if(p != null){
            return p;
        }else{
            throw new PatientNotFoundException("Patient with id: " + patientId + "not found");
        }
    }

    @Override
    public Patient searchPatientByLastName(String name) throws PatientNotFoundException {
        var p = patientRepository.findByLastName(name);
        if(p != null){
            return p;
        }else{
            throw new PatientNotFoundException("Patient not found");
        }
    }

    public List<Patient> getPatientList(){
        var patientList = patientRepository.findAll().stream().sorted(Comparator.comparing(Patient::getLastName)).toList();
        return patientList;
    }

    @Override
    public void deletePatient(Integer patientId){
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient updatePatient(Integer patientId,Patient patient) throws PatientNotFoundException {
        var foundPatient = patientRepository.findById(patientId).orElse(null);
        if(foundPatient != null){
            foundPatient = patient;
            patientRepository.save(foundPatient);
            return foundPatient;
        }else{
            throw new PatientNotFoundException("Patient with id: " + patientId + "not found");
        }
    }
}
