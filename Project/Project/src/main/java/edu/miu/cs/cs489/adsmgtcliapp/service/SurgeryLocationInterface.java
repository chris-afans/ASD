package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.AddressNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.SurgeryLocationNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocationDTO;

import java.util.List;

public interface SurgeryLocationInterface {

    SurgeryLocationDTO addSurgeryLocation(Integer addressId, SurgeryLocation surgeryLocation) throws AddressNotFoundException;
    SurgeryLocationDTO getSurgeryLocation(Integer id);
    List<SurgeryLocationDTO> getSurgeryLocations();
    SurgeryLocationDTO updateSurgeryLocation(Integer id, SurgeryLocation surgeryLocation) throws SurgeryLocationNotFoundException;
    void deleteSurgeryLocation(Integer id);
}
