package edu.miu.cs.cs489.lab11.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    private Integer appointment_id;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", unique = false)
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id", unique = false)
    private Dentist dentist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "surgerylocation_id", unique = false)
    private SurgeryLocation surgeryLocation;
}
