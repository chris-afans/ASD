package edu.miu.cs.cs489.lab11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Integer address_id;
    private String street;
    private String city;
    private String state;
    private String zip;
}
