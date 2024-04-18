package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;

import java.util.List;

public interface PatientServiceInterface {

    Patient addPatient(Patient p);
    Patient searchPatientById(Integer id) throws PatientNotFoundException;
    Patient searchPatientByLastName(String lastName) throws PatientNotFoundException;
    List<Patient> getPatientList();
    Patient updatePatient(Integer id, Patient p) throws PatientNotFoundException;
    void deletePatient(Integer id);
}
