package edu.miu.cs.cs489.lab6.repository;

import edu.miu.cs.cs489.lab6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
