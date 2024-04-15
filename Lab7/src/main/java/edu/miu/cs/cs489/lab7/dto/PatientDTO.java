package edu.miu.cs.cs489.lab7.dto;

import edu.miu.cs.cs489.lab7.model.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Integer patient_id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dob;
    private Address address;
}
