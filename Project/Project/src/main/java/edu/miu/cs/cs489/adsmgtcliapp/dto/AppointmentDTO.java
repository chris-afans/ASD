package edu.miu.cs.cs489.adsmgtcliapp.dto;


import edu.miu.cs.cs489.adsmgtcliapp.model.*;
import edu.miu.cs.cs489.adsmgtcliapp.model.DentistDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {


    private Integer appointment_id;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private PatientDTO patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private DentistDTO dentist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "surgerylocation_id")
    private SurgeryLocationDTO surgeryLocation;
}
