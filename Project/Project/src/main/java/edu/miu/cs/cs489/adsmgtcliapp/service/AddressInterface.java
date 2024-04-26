package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AddressDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.Address;

import java.util.List;

public interface AddressInterface {

    AddressDTO addAddress(Address a);
    List<AddressDTO> getAllAddresses();
}
