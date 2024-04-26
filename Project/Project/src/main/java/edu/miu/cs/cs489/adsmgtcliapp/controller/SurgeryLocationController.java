package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AddressNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.SurgeryLocationNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocationDTO;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.SurgeryLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurgeryLocationController {

    private SurgeryLocationService surgeryLocationService;

    public SurgeryLocationController(SurgeryLocationService surgeryLocationService) {
        this.surgeryLocationService = surgeryLocationService;
    }

    @PostMapping("/adsweb/api/v1/surgerylocation/register/{addressId}")
    public ResponseEntity<SurgeryLocationDTO> addSurgeryLocation(@PathVariable Integer addressId, @RequestBody SurgeryLocation surgeryLocation) throws AddressNotFoundException {
        var sLocation = surgeryLocationService.addSurgeryLocation(addressId,surgeryLocation);
        return new ResponseEntity<>(sLocation, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/surgerylocation/{locationid}")
    public ResponseEntity<SurgeryLocationDTO> getSurgeryLocationById(@PathVariable Integer locationId){
        var sLocation = surgeryLocationService.getSurgeryLocation(locationId);
        return new ResponseEntity<>(sLocation, HttpStatus.OK);
    }

    @GetMapping("/adsweb/api/v1/surgerylocations")
    public ResponseEntity<List<SurgeryLocationDTO>> getAllSurgeryLocations(){
        var locationList = surgeryLocationService.getSurgeryLocations();
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @PutMapping("/adsweb/api/v1/surgerylocation/update/{id}")
    public ResponseEntity<SurgeryLocationDTO> updateSurgeryLocation(@PathVariable Integer id, @RequestBody SurgeryLocation surgeryLocation) throws SurgeryLocationNotFoundException {
        var sLocation = surgeryLocationService.updateSurgeryLocation(id, surgeryLocation);
        return new ResponseEntity<>(sLocation, HttpStatus.OK);
    }

    @DeleteMapping("/adsweb/api/v1/surgerylocation/delete/{id}")
    public ResponseEntity<?> deleteSurgeryLocation(@PathVariable Integer id){
        surgeryLocationService.deleteSurgeryLocation(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
