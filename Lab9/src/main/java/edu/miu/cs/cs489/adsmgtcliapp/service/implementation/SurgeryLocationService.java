package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.SurgeryLocationNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocation;
import edu.miu.cs.cs489.adsmgtcliapp.repository.SurgeryLocationRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.SurgeryLocationInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryLocationService implements SurgeryLocationInterface {

    private SurgeryLocationRepository surgeryLocationRepository;

    public SurgeryLocationService(SurgeryLocationRepository surgeryLocationRepository) {
        this.surgeryLocationRepository = surgeryLocationRepository;
    }

    @Override
    public SurgeryLocation addSurgeryLocation(SurgeryLocation surgeryLocation) {
        return surgeryLocationRepository.save(surgeryLocation);
    }

    @Override
    public SurgeryLocation getSurgeryLocation(Integer id) {
        return surgeryLocationRepository.findById(id).orElse(null);
    }

    @Override
    public List<SurgeryLocation> getSurgeryLocations() {
        return surgeryLocationRepository.findAll();
    }

    @Override
    public SurgeryLocation updateSurgeryLocation(Integer id, SurgeryLocation surgeryLocation) throws SurgeryLocationNotFoundException {
        var surgeryLocationToUpdate = surgeryLocationRepository.findById(id).orElse(null);
        if(surgeryLocationToUpdate != null){
            surgeryLocationToUpdate = surgeryLocation;
            surgeryLocationRepository.save(surgeryLocationToUpdate);
            return surgeryLocationToUpdate;
        }else{
            throw new SurgeryLocationNotFoundException("Patient with id: " + id + "not found");
        }
    }

    @Override
    public void deleteSurgeryLocation(Integer id) {
        surgeryLocationRepository.deleteById(id);
    }
}
