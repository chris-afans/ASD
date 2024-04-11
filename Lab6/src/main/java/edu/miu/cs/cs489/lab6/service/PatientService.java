package edu.miu.cs.cs489.lab6.service;

import edu.miu.cs.cs489.lab6.model.Patient;
import edu.miu.cs.cs489.lab6.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
