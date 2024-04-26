package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AddressNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.SurgeryLocationNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocationDTO;
import edu.miu.cs.cs489.adsmgtcliapp.repository.AddressRepository;
import edu.miu.cs.cs489.adsmgtcliapp.repository.SurgeryLocationRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.SurgeryLocationInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryLocationService implements SurgeryLocationInterface {
    @Autowired
    private AddressService addressService;
    @Autowired
    private  AddressRepository addressRepository;
    @Autowired
    private SurgeryLocationRepository surgeryLocationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SurgeryLocationService() {

    }

    @Override
    public SurgeryLocationDTO addSurgeryLocation(Integer addressId, SurgeryLocation surgeryLocation) throws AddressNotFoundException {
        var address = addressRepository.findById(addressId).orElse(null);
        if (address == null) {
            throw new AddressNotFoundException("address not found");
        }else{
            surgeryLocation.setAddress(address);
            surgeryLocationRepository.save(surgeryLocation);
            return modelMapper.map(surgeryLocation, SurgeryLocationDTO.class);
        }

    }

    @Override
    public SurgeryLocationDTO getSurgeryLocation(Integer id) {
        var location = surgeryLocationRepository.findById(id).orElse(null);
        return modelMapper.map(location, SurgeryLocationDTO.class);
    }

    @Override
    public List<SurgeryLocationDTO> getSurgeryLocations() {
        return surgeryLocationRepository.findAll().stream()
                .map((l)-> modelMapper.map(l, SurgeryLocationDTO.class)).toList();
    }

    @Override
    public SurgeryLocationDTO updateSurgeryLocation(Integer id, SurgeryLocation surgeryLocation) throws SurgeryLocationNotFoundException {
        var surgeryLocationToUpdate = surgeryLocationRepository.findById(id).orElse(null);
        if(surgeryLocationToUpdate != null){
            surgeryLocationToUpdate = surgeryLocation;
            surgeryLocationRepository.save(surgeryLocationToUpdate);
            return modelMapper.map(surgeryLocationToUpdate, SurgeryLocationDTO.class);
        }else{
            throw new SurgeryLocationNotFoundException("Patient with id: " + id + "not found");
        }
    }

    @Override
    public void deleteSurgeryLocation(Integer id) {
        surgeryLocationRepository.deleteById(id);
    }
}
