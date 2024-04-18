package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.model.Address;
import edu.miu.cs.cs489.adsmgtcliapp.repository.AddressRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.AddressInterface;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressService implements AddressInterface {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses(){
        var addresslist = addressRepository.findAll().stream().sorted(Comparator.comparing(Address::getCity)).toList();
        return addresslist;
    }
}
