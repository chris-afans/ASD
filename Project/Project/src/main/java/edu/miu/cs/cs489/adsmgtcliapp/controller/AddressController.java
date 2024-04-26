package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AddressDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.Address;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/adsweb/api/v1/address/register")
    public ResponseEntity<AddressDTO> addAddress(@RequestBody Address address) {
            var add = addressService.addAddress(address);
            return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/address/list")
    public ResponseEntity<List<AddressDTO>> getAllAddresses(){
        var addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

}