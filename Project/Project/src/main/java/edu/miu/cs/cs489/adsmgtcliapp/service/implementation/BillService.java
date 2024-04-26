package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Bill;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.repository.BillRepository;
import edu.miu.cs.cs489.adsmgtcliapp.repository.PatientRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.BillInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService implements BillInterface {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PatientDTO addBill(Integer patientId, Bill bill) throws PatientNotFoundException {
        var patient = patientService.searchPatientById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException("patient not found");
        } else {
            var billList = patient.getBills().add(bill);
            patientRepository.save(modelMapper.map(patient, Patient.class));
            return patient;
        }
    }
}
