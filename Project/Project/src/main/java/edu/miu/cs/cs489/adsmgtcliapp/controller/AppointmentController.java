package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.DentistAppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.PatientAppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.UserDTO;
import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import edu.miu.cs.cs489.adsmgtcliapp.model.User;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/adsweb/api/v1/appointment/register/{patientId}/{dentistId}/{locationId}")
    public ResponseEntity<AppointmentDTO> addAppointment(@PathVariable Integer patientId, @PathVariable Integer locationId, @PathVariable Integer dentistId, @RequestBody Appointment appointment) throws PatientNotFoundException, DentistNotFoundException {
        var app = appointmentService.addAppointment(patientId, dentistId, locationId, appointment);
        return new ResponseEntity<>(app, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/appointment/{appointmentId}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Integer appointmentId) throws AppointmentNotFoundException {
        var app = appointmentService.getAppointment(appointmentId);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        var appointmentList = appointmentService.getAppointmentsList();
        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/appointments/patient/{patientId}")
    public ResponseEntity<List<PatientAppointmentDTO>> getAppointmentByPatient(@PathVariable Integer patientId){
//        var auth = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        var patientId = auth.getUserId();

        var appList = appointmentService.getAppointmentsByPatient(patientId);
        return new ResponseEntity<>(appList, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/appointments/dentist/{dentistId}")
    public ResponseEntity<List<DentistAppointmentDTO>> getAppointmentByDentist(@PathVariable Integer dentistId){
//        var auth = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        var dentistId = auth.getUserId();
        var appList = appointmentService.getAppointmentsByDentist(dentistId);
        return new ResponseEntity<>(appList, HttpStatus.OK);
    }

    @PutMapping("/adsweb/api/v1/appointment/update/{id}")
    public ResponseEntity<AppointmentDTO> updateSurgeryLocation(@PathVariable Integer id, @RequestBody Appointment appointment) throws AppointmentNotFoundException {
        var app = appointmentService.updateAppointment(id, appointment);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @DeleteMapping("/adsweb/api/v1/appointment/delete/{id}")
    public ResponseEntity<?> deleteSurgeryLocation(@PathVariable Integer id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
