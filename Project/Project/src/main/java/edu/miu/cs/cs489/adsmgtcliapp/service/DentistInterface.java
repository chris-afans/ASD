package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Dentist;
import edu.miu.cs.cs489.adsmgtcliapp.model.DentistDTO;

import java.util.List;

public interface DentistInterface {

    DentistDTO addDentist(Dentist d);
    List<DentistDTO> getAllDentists();
    DentistDTO getDentist(Integer id) throws DentistNotFoundException;
    DentistDTO updateDentist(Integer id, Dentist d) throws DentistNotFoundException;
    void deleteDentist(Integer id);
}
