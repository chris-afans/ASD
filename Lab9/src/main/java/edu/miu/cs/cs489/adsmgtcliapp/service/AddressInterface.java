package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.model.Address;

import java.util.List;

public interface AddressInterface {

    Address addAddress(Address a);
    List<Address> getAllAddresses();
}
