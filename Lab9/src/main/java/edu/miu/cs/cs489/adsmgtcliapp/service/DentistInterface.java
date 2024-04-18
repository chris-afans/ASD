package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Dentist;

import java.util.List;

public interface DentistInterface {

    Dentist addDentist(Dentist d);
    List<Dentist> getAllDentists();
    Dentist getDentist(Integer id) throws DentistNotFoundException;
    Dentist updateDentist(Integer id, Dentist d) throws DentistNotFoundException;
    void deleteDentist(Integer id);
}
