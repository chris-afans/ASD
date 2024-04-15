package edu.miu.cs.cs489.lab7.service;

import edu.miu.cs.cs489.lab7.model.Patient;
import edu.miu.cs.cs489.lab7.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient searchPatientById(Integer patientId){
        Patient p = patientRepository.findById(patientId).orElse(null);
        if(p != null){
            return p;
        }else{
            throw new IllegalArgumentException("patient not found");
        }
    }

    public Patient searchPatientByLastName(String name){
        var p = patientRepository.findByLastName(name);
        if(p != null){
            return p;
        }else{
            throw new IllegalArgumentException("patient not found");
        }
    }

    public List<Patient> getPatientList(){
        var patientList = patientRepository.findAll().stream().sorted(Comparator.comparing(Patient::getLastName)).toList();
        return patientList;
    }

    public void deletePatient(Integer patientId){
        patientRepository.deleteById(patientId);
    }

    public Patient updatePatient(Integer patientId,Patient patient){
        var foundPatient = patientRepository.findById(patientId).orElse(null);
        if(foundPatient != null){
            foundPatient = patient;
            patientRepository.save(foundPatient);
            return foundPatient;
        }else{
            throw new IllegalArgumentException("Patient not found");
        }
    }
}
