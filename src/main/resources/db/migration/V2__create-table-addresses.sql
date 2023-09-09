create table addresses(

    address_id bigint not null auto_increment,
    doctor_id bigint,
    number int not null,
    street varchar(100) not null,
    neighborhood varchar(100),
    complement varchar(100),
    city varchar(100) not null,
    state varchar(100) not null,
    country varchar(100) not null,
    zipcode varchar(20) not null,
    primary key(address_id),
    foreign key(doctor_id) references doctors(doctor_id)

);