package edu.miu.cs.cs489.adsmgtcliapp.dto;

import edu.miu.cs.cs489.adsmgtcliapp.model.Address;
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
