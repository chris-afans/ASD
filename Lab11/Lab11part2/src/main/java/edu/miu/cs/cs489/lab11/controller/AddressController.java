package edu.miu.cs.cs489.lab11.controller;

import edu.miu.cs.cs489.lab11.model.Address;
import edu.miu.cs.cs489.lab11.service.AddressService;
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
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
            var add = addressService.addAddress(address);
            return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("/adsweb/api/v1/address/list")
    public ResponseEntity<List<Address>> getAllAddresses(){
        var addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

}
