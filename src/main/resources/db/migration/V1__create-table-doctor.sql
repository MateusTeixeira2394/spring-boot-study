create table doctors(

  doctor_id bigint not null auto_increment,
  name varchar(100) not null,
  email varchar(100) not null unique,
  crm varchar(6) not null unique,
  speciality varchar(100) not null,
  telephone varchar(50),
  primary key(doctor_id)

);