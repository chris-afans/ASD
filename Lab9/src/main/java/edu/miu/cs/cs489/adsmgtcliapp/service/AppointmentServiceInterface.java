package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;

import java.util.List;

public interface AppointmentServiceInterface {

    Appointment addAppointment(Appointment appointment);
    List<Appointment> getAppointmentsList();
    Appointment getAppointment(Integer id) throws AppointmentNotFoundException;
    Appointment updateAppointment(Integer id, Appointment appointment) throws AppointmentNotFoundException;
    void deleteAppointment(Integer id);
}
