create database asd;
use asd;

create table users(
	userId INT NOT NULL,
    username varchar(20),
    rolesId INT not null,
    Primary Key(userId)
);


create table roles(
	rolesId INT NOT NULL,
    name varchar(25) not null,
    userrole INT not null,
    primary key(rolesId)
);

create table Patient(
	patientId INT NOT NULL,
    firstname varchar(35) not null,
    lastname varchar(25) not null,
    email varchar(45) not null,
    phone_no varchar(12),
    dob varchar(10),
    addressId INT NOT NULL,
    primary key(patientId)    
);

create table Dentist(
	dentistId INT NOT NULL,
    firstname varchar(35) not null,
    lastname varchar(25) not null,
    email varchar(45) not null,
    phone_no varchar(12),
    specialization varchar(45),
    primary key(dentistId)
);

create table Appointment(
	appointmentId int NOT NULL,
    appointment_date varchar(10) NOT NULL,
    appointment_time varchar(8) NOT NULL,
    patientId int not null,
    dentistId int not null,
    locationId int not null,
    primary key(appointmentId)
);

create table SurgeryLocation(
	locationId INT NOT NULL,
    locationName varchar(45) not null,
    telephone_no varchar(12) not null,
    addressId int not null,
    primary key(locationId)
);

create table Address(
	addressId INT NOT NULL,
    street varchar(45) not null,
    city varchar(25) not null,
    zip varchar(5) not null,
    state varchar(2) not null,
    primary key(addressId)
);

create table Bill(
	billId INT NOT NULL,
    dental_service varchar(45) not null,
    amount double not null,
    bill_status varchar(10),
    primary key(billId)
);

ALTER TABLE users ADD FOREIGN KEY(rolesId) REFERENCES roles(rolesId);
ALTER TABLE patient ADD FOREIGN KEY(addressId) REFERENCES address(addressId);
ALTER TABLE appointment 
ADD FOREIGN KEY(patientId) REFERENCES patient(patientId),
ADD FOREIGN KEY(dentistId) REFERENCES dentist(dentistId),
ADD FOREIGN KEY(locationId) REFERENCES surgerylocation(locationId);
ALTER TABLE surgerylocation ADD FOREIGN KEY(addressId) REFERENCES address(addressId);


insert into roles (rolesId, name, userrole) values (1, "Office Manager", 0),
(2, "Patient", 1), (3, "Dentist", "1"), (4, "Dentist", "1"), (5, "Dentist", "1");

insert into users (userId, username, rolesId) values
(1, "johndoe", 1), (2, "jonsnow", 2), (3, "keverdeen", 3), (4, "galej", 4),
(5, "cafanam", 5);

insert into address(addressId, street, city, zip, state) values 
(1, "1000 N 4th St", "Fairfield", "52556", "IA"), (2, "1023 S 5th St", "Leander", "78651", "TX"),
(3, "1010 N 5th St", "Fairfield", "52556", "IA"), (4, "1234 N 4th St", "Chicago", "52656", "IL"),
(5, "100 SW 6TH ST", "Fairfield", "52556", "IA");



insert into patient(patientId, firstname, lastname, email, phone_no, dob, addressId) values 
(1, "John", "Snow", "jons@gmail.com", "641-233-8989", "1978-09-03", 1);

insert into dentist(dentistId, firstname, lastname, email, phone_no, specialization) values
(1, "Katniss", "Everdeen", "k.a@gmail.com", "712-897-0000", "endodontics"),
(2, "Gale", "Jones", "galej@gmail.com", "712-897-1200", "orthodontics"),
(3, "Chrisfel", "Afanam", "cafanam@gmail.com", "612-897-0000", "periodontics");

insert into surgerylocation (locationId, locationName, telephone_no, addressId) values
(1, "D&D dentistry", "312-908-1234", 2), (2, "Bee's Family dentistry", "312-908-1444", 3);

insert into appointment(appointmentId, appointment_date, appointment_time, patientId, dentistId, locationId)
values (1, "2024-04-08", "9:00am", 1, 1, 1), (2, "2024-05-13", "9:00am", 1, 3, 1),
(3, "2024-09-08", "9:00am", 1, 2, 1);


select * from dentist order by lastname;

SELECT Appointment.*, Patient.*
FROM Appointment
JOIN Patient ON Appointment.patientId = Patient.patientId
WHERE Appointment.dentistId = 1;


SELECT Appointment.*, SurgeryLocation.*
FROM Appointment
JOIN SurgeryLocation ON Appointment.locationId = SurgeryLocation.locationId
WHERE Appointment.locationId = 1;

SELECT Appointment.*, Patient.*
FROM Appointment
JOIN Patient ON Appointment.patientId = Patient.patientId
WHERE Patient.patientId = 1 AND Appointment.appointment_date = '2024-09-08';




