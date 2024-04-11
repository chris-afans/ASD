package edu.miu.cs.cs489.lab6.service;

import edu.miu.cs.cs489.lab6.model.Appointment;
import edu.miu.cs.cs489.lab6.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
