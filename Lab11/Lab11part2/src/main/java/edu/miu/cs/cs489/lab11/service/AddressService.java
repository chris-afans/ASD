package edu.miu.cs.cs489.lab11.service;

import edu.miu.cs.cs489.lab11.model.Address;
import edu.miu.cs.cs489.lab11.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAllAddresses(){
        var addresslist = addressRepository.findAll().stream().sorted(Comparator.comparing(Address::getCity)).toList();
        return addresslist;
    }
}
