package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Bill;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    @Autowired
    private BillService billService;


    @PostMapping("/adsweb/api/v1/bill/patient/{patientId}")
    public ResponseEntity<PatientDTO> addBillToPatient(@PathVariable Integer patientId, @RequestBody Bill bill) throws PatientNotFoundException {
        var patient = billService.addBill(patientId, bill);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
}
