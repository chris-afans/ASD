package edu.miu.cs.cs489.adsmgtcliapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan

public class AdsMgtCLIApp implements CommandLineRunner {

//	private AppointmentService appointmentService;
//	private DentistService dentistService;
//	private PatientService patientService;
//
//	public Lab7Application(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
//		this.appointmentService = appointmentService;
//		this.dentistService = dentistService;
//		this.patientService = patientService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AdsMgtCLIApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		createPatient();
//		createDentist();
//		createAppointment();
		//add dentists
//		Address a1 = new Address(1, "1000 N 4th St", "Fairfield", "IA", "52556");
//		Address a2 = new Address(2, "1000 N 6th St", "Fairfield", "IA", "52556");
//		Address a3 = new Address(3, "1000 N 7th St", "Fairfield", "IA", "52556");
//		Address a4 = new Address(4, "1000 N 8th St", "Fairfield", "IA", "52556");
//		Patient p1 = new Patient(1, "Gillian", "White", "123-123-4444", "g.w@gmail.com", LocalDate.of(2000, 9, 11), a1);
//		Patient p2 = new Patient(2, "Jill", "Bell", "123-666-1234", "j.b@gmail.com", LocalDate.of(2001, 9, 11), a2);
//		Patient p3 = new Patient(3, "Ian", "McKay", "123-125-1234", "i.a@gmail.com", LocalDate.of(2000, 11, 11), a3);
//		Patient p4 = new Patient(4, "John", "Walker", "123-903-1234", "j.w@gmail.com", LocalDate.of(1998, 9, 11), a4);

//		Dentist d1 = new Dentist(1, "Tony", "Smith", "t.s@gmail.com", "612-890-7896", "endodontics");
//		Dentist d2 = new Dentist(2, "Helen", "Pearson", "h.p@gmail.com", "612-890-7899", "periodontics");
//		Dentist d3 = new Dentist(3, "Robin", "Plevin", "r.b@gmail.com", "612-890-7996", "orthodontics");
//		dentistService.addDentist(d1);
//		dentistService.addDentist(d2);
//		dentistService.addDentist(d3);
//		Address as1 = new Address(6, "123 sunflower st", "Fairfield", "IA", "50089");
//		Address as2 = new Address(7, "123 sundrops st", "Burlington", "IA", "51123");
//		Address as3 = new Address(8, "123 cactus st", "Ottumwa", "IA", "59087");
//		SurgeryLocation sl1 = new SurgeryLocation(1, "ADS Fairfield", "612-345-5678", as1);
//		SurgeryLocation sl2 = new SurgeryLocation(2, "ADS Burlington", "612-345-9998", as2);
//		SurgeryLocation sl3 = new SurgeryLocation(3, "ADS Ottumwa", "612-345-5609", as3);
//
//		Appointment appt1 = new Appointment(1, LocalDate.of(2024,4,11), LocalTime.of(10,00), p1, d1, sl1);
//		Appointment appt2 = new Appointment(2, LocalDate.of(2024,4,15), LocalTime.of(12,00), p2, d1, sl1);
//		Appointment appt3 = new Appointment(3, LocalDate.of(2024,4,15), LocalTime.of(10,00), p3, d2, sl2);
//		Appointment appt4 = new Appointment(4, LocalDate.of(2024,4,12), LocalTime.of(14,00), p3, d2, sl2);
//		Appointment appt5 = new Appointment(5, LocalDate.of(2024,4,19), LocalTime.of(16,30), p2, d3, sl1);
//		Appointment appt6 = new Appointment(6, LocalDate.of(2024,4,18), LocalTime.of(18,00), p4, d3, sl3);

//		appointmentService.addAppointment(appt1);
//		appointmentService.addAppointment(appt2);
//		appointmentService.addAppointment(appt3);
//		appointmentService.addAppointment(appt4);
//		appointmentService.addAppointment(appt5);
//		appointmentService.addAppointment(appt6);

		//get dentist
//		System.out.println("Getting dentist with id 2");
//		System.out.println(dentistService.getDentist(2));
//
//		//update dentist
//		Dentist dentist = dentistService.getDentist(2);
//		if(dentist != null){
//			dentist.setSpecialization("halidontics");
//			dentistService.updateDentist(dentist);
//		}else{
//			System.out.println(dentist);
//		}
//
//		//delete dentist
//		dentistService.deleteDentists(1);
	}

//	public Patient createPatient(){
//		Patient patient = new Patient(1, "Chrisfel", "Afanam", "123-123-1234", "c.a@gmail.com", LocalDate.of(2000, 9,11));
//		return patientService.addPatient(patient);
//	}
//
//	public Dentist createDentist(){
//		Dentist dentist = new Dentist(1, "Prince", "Tuffour", "p.t@outlook.com", "234-234-2345", "endodontics");
//		return dentistService.addDentist(dentist);
//	}
//
//	public Appointment createAppointment(){
//		Patient patient = new Patient(2, "Chrisfel", "Afanam", "123-123-1234", "c.a@gmail.com", LocalDate.of(2000, 9,11));
//		Dentist dentist = new Dentist(2, "Prince", "Tuffour", "p.t@outlook.com", "234-234-2345", "endodontics");
//		Address a = new Address(1, "1000  N 4th St", "Leander", "TX", "78641");
//		SurgeryLocation sl = new SurgeryLocation(1, "ADS New York", "345-456-5689", a);
//		Appointment app = new Appointment(1, LocalDate.of(2024, 4, 15), LocalTime.of(8, 30), patient, dentist, sl);
//		return appointmentService.addAppointment(app);
//
//	}
}
