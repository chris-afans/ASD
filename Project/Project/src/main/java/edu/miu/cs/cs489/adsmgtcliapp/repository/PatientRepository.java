package edu.miu.cs.cs489.adsmgtcliapp.repository;

import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findByLastName(String lastName);
}
