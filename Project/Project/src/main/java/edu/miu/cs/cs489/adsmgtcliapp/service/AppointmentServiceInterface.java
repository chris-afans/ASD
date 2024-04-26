package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.DentistAppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.PatientAppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;

import java.util.List;

public interface AppointmentServiceInterface {



    AppointmentDTO addAppointment(Integer patientId, Integer dentistId, Integer locationId, Appointment appointment) throws PatientNotFoundException, DentistNotFoundException;

    List<AppointmentDTO> getAppointmentsList();
    AppointmentDTO getAppointment(Integer id) throws AppointmentNotFoundException;
    AppointmentDTO updateAppointment(Integer id, Appointment appointment) throws AppointmentNotFoundException;
    List<DentistAppointmentDTO> getAppointmentsByDentist(Integer dentistId);
    List<PatientAppointmentDTO> getAppointmentsByPatient(Integer patientId);
    void deleteAppointment(Integer id);
}
