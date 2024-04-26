package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;

import java.util.List;

public interface PatientServiceInterface {

    PatientDTO addPatient(Patient p);
    PatientDTO searchPatientById(Integer id) throws PatientNotFoundException;
    PatientDTO searchPatientByLastName(String lastName) throws PatientNotFoundException;
    List<PatientDTO> getPatientList();
    PatientDTO updatePatient(Integer id, Patient p) throws PatientNotFoundException;
    void deletePatient(Integer id);
}
