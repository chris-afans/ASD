package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/adsweb/api/v1/patient/register")
    public ResponseEntity<PatientDTO> addPatient(@RequestBody Patient patient) {
        var pat = patientService.addPatient(patient);
        return new ResponseEntity<>(pat, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/patient/get/{patientId}")
    public ResponseEntity<PatientDTO> searchById(@PathVariable Integer patientId) throws PatientNotFoundException {
        var p = patientService.searchPatientById(patientId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/patient/search/{name}")
    public ResponseEntity<PatientDTO> searchByLastName(@PathVariable String name) throws PatientNotFoundException {
        var p = patientService.searchPatientByLastName(name);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/patient/list")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        var patientlist = patientService.getPatientList();
        return new ResponseEntity<>(patientlist, HttpStatus.OK);
    }

    @PutMapping("/adsweb/api/v1/patient/update/{patientId}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Integer patientId, @RequestBody Patient patient) throws PatientNotFoundException {
        var p = patientService.updatePatient(patientId, patient);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/adsweb/api/v1/patient/delete/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer patientId){
        patientService.deletePatient(patientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
