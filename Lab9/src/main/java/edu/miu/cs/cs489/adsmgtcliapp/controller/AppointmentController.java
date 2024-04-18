package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Appointment;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/adsweb/api/v1/appointment/register")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        var app = appointmentService.addAppointment(appointment);
        return new ResponseEntity<>(app, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/appointment/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer appointmentId) throws AppointmentNotFoundException {
        var app = appointmentService.getAppointment(appointmentId);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        var appointmentList = appointmentService.getAppointmentsList();
        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }

    @PutMapping("/adsweb/api/v1/appointment/update/{id}")
    public ResponseEntity<Appointment> updateSurgeryLocation(@PathVariable Integer id, @RequestBody Appointment appointment) throws AppointmentNotFoundException {
        var app = appointmentService.updateAppointment(id, appointment);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @DeleteMapping("/adsweb/api/v1/appointment/delete/{id}")
    public ResponseEntity<?> deleteSurgeryLocation(@PathVariable Integer id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
