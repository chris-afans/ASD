package edu.miu.cs.cs489.lab6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist {
    @Id
    private Integer dentist_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String specialization;


}
