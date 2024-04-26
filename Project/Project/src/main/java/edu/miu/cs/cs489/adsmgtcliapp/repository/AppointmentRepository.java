package edu.miu.cs.cs489.adsmgtcliapp.repository;

import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "select p from Appointment p where p.patient.patient_id = :patientId")
    List<Appointment> findAppointmentsByPatient(Integer patientId);

    @Query(value = "select p from Appointment p where p.dentist.dentist_id = :dentistId")
    List<Appointment> findAppointmentsByDentist(Integer dentistId);
 }
