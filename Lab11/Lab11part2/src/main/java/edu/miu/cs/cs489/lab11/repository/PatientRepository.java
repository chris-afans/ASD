package edu.miu.cs.cs489.lab11.repository;

import edu.miu.cs.cs489.lab11.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findByLastName(String lastName);
}
