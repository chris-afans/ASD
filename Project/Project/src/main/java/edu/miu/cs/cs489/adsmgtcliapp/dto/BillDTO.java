package edu.miu.cs.cs489.adsmgtcliapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

    private Integer id;
    private String serviceReceived;
    private Double amount;
    private String paymentStatus;
}
