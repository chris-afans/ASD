package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.model.Dentist;
import edu.miu.cs.cs489.adsmgtcliapp.model.DentistDTO;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DentistContoller {

    @Autowired
    private DentistService dentistService;

    @PostMapping("/adsweb/api/v1/dentist/register")
    public ResponseEntity<DentistDTO> addDentist(@RequestBody Dentist dentist) {
        var d = dentistService.addDentist(dentist);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
}
