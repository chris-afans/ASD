package edu.miu.cs.cs489.lab7.repository;

import edu.miu.cs.cs489.lab7.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
