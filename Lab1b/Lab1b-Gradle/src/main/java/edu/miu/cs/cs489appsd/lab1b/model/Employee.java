package edu.miu.cs.cs489appsd.lab1b.model;




import java.time.LocalDate;


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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPp() {
        return pp;
    }

    public void setPp(PensionPlan pp) {
        this.pp = pp;
    }
}
