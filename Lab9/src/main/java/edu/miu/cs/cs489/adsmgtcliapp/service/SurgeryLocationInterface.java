package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.SurgeryLocationNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;

import java.util.List;

public interface SurgeryLocationInterface {

    SurgeryLocation addSurgeryLocation(SurgeryLocation surgeryLocation);
    SurgeryLocation getSurgeryLocation(Integer id);
    List<SurgeryLocation> getSurgeryLocations();
    SurgeryLocation updateSurgeryLocation(Integer id, SurgeryLocation surgeryLocation) throws SurgeryLocationNotFoundException;
    void deleteSurgeryLocation(Integer id);
}
