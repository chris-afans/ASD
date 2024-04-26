package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Bill;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;

public interface BillInterface {

    public PatientDTO addBill(Integer patientId, Bill bill) throws PatientNotFoundException;
}
