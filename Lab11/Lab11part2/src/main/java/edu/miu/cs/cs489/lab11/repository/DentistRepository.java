package edu.miu.cs.cs489.lab11.repository;

import edu.miu.cs.cs489.lab11.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
