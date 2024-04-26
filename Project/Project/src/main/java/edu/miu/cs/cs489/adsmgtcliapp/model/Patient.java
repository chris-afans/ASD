package edu.miu.cs.cs489.adsmgtcliapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patient_id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dob;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "billId")
    private List<Bill> bills;
}
