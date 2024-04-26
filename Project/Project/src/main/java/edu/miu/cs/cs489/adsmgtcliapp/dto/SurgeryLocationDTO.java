package edu.miu.cs.cs489.adsmgtcliapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SurgeryLocationDTO {

    private Integer id;
    private String name;
    private String telephoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
}
