package edu.miu.cs.cs489.adsmgtcliapp.repository;

import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryLocationRepository extends JpaRepository<SurgeryLocation, Integer> {
}
