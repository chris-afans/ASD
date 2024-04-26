package edu.miu.cs.cs489.adsmgtcliapp.model;


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
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer appointment_id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "surgerylocation_id")
    private SurgeryLocation surgeryLocation;
}
