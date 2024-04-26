package edu.miu.cs.cs489.adsmgtcliapp.dto;

import edu.miu.cs.cs489.adsmgtcliapp.model.DentistDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.SurgeryLocationDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistAppointmentDTO {

    private Integer appointment_id;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private PatientDTO patient;

}
