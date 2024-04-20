package edu.miu.cs.cs489.lab11.repository;

import edu.miu.cs.cs489.lab11.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
