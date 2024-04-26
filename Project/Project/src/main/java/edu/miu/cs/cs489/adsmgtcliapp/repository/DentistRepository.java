package edu.miu.cs.cs489.adsmgtcliapp.repository;

import edu.miu.cs.cs489.adsmgtcliapp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
