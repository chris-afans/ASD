package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AddressDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.Address;
import edu.miu.cs.cs489.adsmgtcliapp.repository.AddressRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.AddressInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressService implements AddressInterface {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;



    public AddressService() {

    }

    @Override
    public AddressDTO addAddress(Address address) {
        addressRepository.save(address);
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAllAddresses(){
        var addresslist = addressRepository.findAll().stream()
                .map((a) -> modelMapper.map(a, AddressDTO.class))
                .sorted(Comparator.comparing(AddressDTO::getCity)).toList();
        return addresslist;
    }
}
