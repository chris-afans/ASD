package edu.miu.cs.cs489appsd.lab1b;

import edu.miu.cs.cs489appsd.lab1b.model.Employee;
import edu.miu.cs.cs489appsd.lab1b.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    public static void printAllEmployees(List<Employee> emps){
        List<Employee> empSorted = emps.stream()
                .sorted(comparing(Employee::getLastName).thenComparing(comparing(Employee::getYearlySalary).reversed())).toList();
        System.out.println("PRINTING ALL EMPLOYEE INFORMATION");
        System.out.println("[");
        for(Employee e : empSorted){
            if(e.getPp() == null) {
                System.out.println("   {" + "\"employeeId\": " + e.getEmployeeId() + "," + " \"Firstname\": " + e.getFirstName() + "," + " \"Lastname\": " + e.getLastName() + "," + " \"EmploymentDate\": " + e.getEmploymentDate() + "," + " \"yearlySalary\": " + e.getYearlySalary() + "}");
            }else{
                System.out.println("   {" + "\"employeeId\": " + e.getEmployeeId() + "," + " \"Firstname\": " + e.getFirstName() + "," + " \"Lastname\": " + e.getLastName() + "," + " \"EmploymentDate\": " + e.getEmploymentDate() + "," + " \"yearlySalary\": " + e.getYearlySalary() +  "," +" \"Plan ReferenceNo\": " + e.getPp().getPlanReferenceNumber()+  "," + " \"Enrollment Date\": " + e.getPp().getEnrollmentDate()+ "," +" \"Monthly Contribution\": " + e.getPp().getMonthlyContribution()+ "}");
            }
        }
        System.out.println("]");
    }


    public static void monthlyUpcomingEnroleesReport(List<Employee> emps){
        System.out.println("MONTHLY UPCOMING ENROLEES REPORT");
        System.out.println("[");
        var currentDate = LocalDate.now();
        var nextMonth = currentDate.plusMonths(1);

        for(Employee e : emps){
            LocalDate empNewDate = e.getEmploymentDate().plusYears(5);

            if(e.getPp() == null && empNewDate.getYear() == nextMonth.getYear() && empNewDate.getMonth() == nextMonth.getMonth()){
                System.out.println("   {" + "\"employeeId\": " + e.getEmployeeId() + "," + " \"Firstname\": " + e.getFirstName() + "," + " \"Lastname\": " + e.getLastName() + "," + " \"EmploymentDate\": " + e.getEmploymentDate() + "," + " \"yearlySalary\": " + e.getYearlySalary() + "}");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        var p1 = new PensionPlan("EX1089", LocalDate.of(2023, 01,17), 100.00);
        var p2 = new PensionPlan("SM2307", LocalDate.of(2019, 05,02), 1555.50);

        var e1 = new Employee(null,"Daniel", "Agar", LocalDate.of(2018,01,17), 105945.50, p1);
        var e2 = new Employee(null,"Benard", "Shaw", LocalDate.of(2019,04,03), 197750.00, null);
        var e3 = new Employee(null,"Carly", "Agar", LocalDate.of(2014,05,16), 842000.75, p2);
        var e4 = new Employee(null,"Wesley", "Schneider", LocalDate.of(2019,05,02), 74500.00, null);



        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        printAllEmployees(employees);
        System.out.println("-------------------------------------");
        monthlyUpcomingEnroleesReport(employees);

    }
}