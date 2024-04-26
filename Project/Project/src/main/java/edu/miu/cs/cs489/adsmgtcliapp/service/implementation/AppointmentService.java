package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.DentistAppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.dto.PatientAppointmentDTO;
import edu.miu.cs.cs489.adsmgtcliapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.DentistNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.*;
import edu.miu.cs.cs489.adsmgtcliapp.model.DentistDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocationDTO;
import edu.miu.cs.cs489.adsmgtcliapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.adsmgtcliapp.repository.DentistRepository;
import edu.miu.cs.cs489.adsmgtcliapp.repository.PatientRepository;
import edu.miu.cs.cs489.adsmgtcliapp.repository.SurgeryLocationRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.AppointmentServiceInterface;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;
    @Autowired
    private SurgeryLocationService surgeryLocationService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DentistRepository dentistRepository;
    @Autowired
    private SurgeryLocationRepository surgeryLocationRepository;


    @Override
    public AppointmentDTO addAppointment(Integer patientId, Integer dentistId, Integer locationId,
                                         Appointment appointment) throws PatientNotFoundException, DentistNotFoundException {
        var patient = patientRepository.findById(patientId).orElse(null);
        var dentist = dentistRepository.findById(dentistId).orElse(null);
        var location  = surgeryLocationRepository.findById(locationId).orElse(null);


        var billList = patient.getBills().stream().filter(e-> e.getPaymentStatus().equalsIgnoreCase("Pending")).toList();
        if(billList.size() > 0){
            throw new IllegalArgumentException("Patient cannot book appointment unless outstanding bill is paid");
        }else{
            appointment.setPatient(patient);
            appointment.setDentist(dentist);
            appointment.setSurgeryLocation(location);
            var savedAppointment = appointmentRepository.save(appointment);

            var a = modelMapper.map(savedAppointment, AppointmentDTO.class);
            a.setPatient(modelMapper.map(savedAppointment.getPatient(), PatientDTO.class));
            a.setDentist(modelMapper.map(savedAppointment.getDentist(), DentistDTO.class));
            a.setSurgeryLocation(modelMapper.map(savedAppointment.getSurgeryLocation(), SurgeryLocationDTO.class));
            return a;
        }


    }

    @Override
    public List<AppointmentDTO> getAppointmentsList() {
        return appointmentRepository.findAll().stream()
                .map((a)-> modelMapper.map(a, AppointmentDTO.class)).toList();
    }

    @Override
    public AppointmentDTO getAppointment(Integer id) throws AppointmentNotFoundException {
        Appointment app = appointmentRepository.findById(id).orElse(null);
        if(app != null){
            return modelMapper.map(app, AppointmentDTO.class);
        }else{
            throw new AppointmentNotFoundException("Appointment with id: " + id + "not found");
        }
    }

    @Override
    public AppointmentDTO updateAppointment(Integer id, Appointment appointment) throws AppointmentNotFoundException {
        var foundAppointment = appointmentRepository.findById(id).orElse(null);
        if(foundAppointment != null){
            foundAppointment = appointment;
            appointmentRepository.save(foundAppointment);
            return modelMapper.map(foundAppointment, AppointmentDTO.class);
        }else{
            throw new AppointmentNotFoundException("Appointment with id: " + id + "not found");
        }
    }

    @Override
    public List<DentistAppointmentDTO> getAppointmentsByDentist(Integer dentistId) {
        return appointmentRepository.findAppointmentsByDentist(dentistId).stream()
                .map((a)-> modelMapper.map(a, DentistAppointmentDTO.class)).toList();


    }

    @Override
    public List<PatientAppointmentDTO> getAppointmentsByPatient(Integer patientId) {
        return appointmentRepository.findAppointmentsByPatient(patientId).stream()
                .map((a)-> modelMapper.map(a, PatientAppointmentDTO.class)).toList();
    }

    @Override
    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
