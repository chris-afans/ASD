package edu.miu.cs.cs489appsd.lab1b.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Double monthlyContribution;


    public PensionPlan(){}
    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution){
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }


}
