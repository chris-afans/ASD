package edu.miu.cs.cs489.lab7.controller;

import edu.miu.cs.cs489.lab7.model.Patient;
import edu.miu.cs.cs489.lab7.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/adsweb/api/v1/patient/register")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        var pat = patientService.addPatient(patient);
        return new ResponseEntity<>(pat, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/patient/get/{patientId}")
    public ResponseEntity<Patient> searchById(@PathVariable Integer patientId){
        var p = patientService.searchPatientById(patientId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/patient/search/{name}")
    public ResponseEntity<Patient> searchByLastName(@PathVariable String name){
        var p = patientService.searchPatientByLastName(name);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/patient/list")
    public ResponseEntity<List<Patient>> getAllPatients(){
        var patientlist = patientService.getPatientList();
        return new ResponseEntity<>(patientlist, HttpStatus.OK);
    }

    @PutMapping("/adsweb/api/v1/patient/update/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId, @RequestBody Patient patient){
        var p = patientService.updatePatient(patientId, patient);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/adsweb/api/v1/patient/delete/{patientId}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Integer patientId){
        patientService.deletePatient(patientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
