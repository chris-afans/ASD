package edu.miu.cs.cs489appsd.lab1b.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearlySalary;
    private PensionPlan pp;

    public Employee(){}
    public Employee(Long employeeId, String fName, String lName, LocalDate employmentDate, Double yrlySalary, PensionPlan pp){
        this.employeeId = employeeId;
        this.firstName = fName;
        this.lastName = lName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yrlySalary;
        this.pp = pp;
    }

    public Employee(String fName, String lName, LocalDate employmentDate, Double yrlySalary, PensionPlan pp){
        this.firstName = fName;
        this.lastName = lName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yrlySalary;
        this.pp = pp;
    }


}
