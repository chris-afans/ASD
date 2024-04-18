package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.AppointmentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsList() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointment(Integer id) throws AppointmentNotFoundException {
        Appointment app = appointmentRepository.findById(id).orElse(null);
        if(app != null){
            return app;
        }else{
            throw new AppointmentNotFoundException("Appointment with id: " + id + "not found");
        }
    }

    @Override
    public Appointment updateAppointment(Integer id, Appointment appointment) throws AppointmentNotFoundException {
        var foundAppointment = appointmentRepository.findById(id).orElse(null);
        if(foundAppointment != null){
            foundAppointment = appointment;
            appointmentRepository.save(foundAppointment);
            return foundAppointment;
        }else{
            throw new AppointmentNotFoundException("Appointment with id: " + id + "not found");
        }
    }

    @Override
    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
