create database mydb;

create table admin
(
	id varchar(255) null,
	first_name varchar(255) null,
	last_name varchar(255) null,
	username varchar(255) null,
	password varchar(255) null,
	email varchar(255) null,
	activation_code varchar(255) null,
	role varchar(255) null
)
;

create table customer
(
	id varchar(255) not null
		primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	username varchar(255) not null,
	password varchar(255) not null,
	email varchar(255) not null,
	activation_code varchar(255) not null,
	role varchar(45) not null,
	phone_number varchar(255) null,
	card_number varchar(255) null,
	date_of_birth date null,
	passport_info varchar(255) null
)
;

create table travel_agency
(
	id varchar(255) not null
		primary key,
	name varchar(255) not null,
	count_tour int not null,
	count_travel_agents int not null
)
;

create table tour
(
	id varchar(255) not null
		primary key,
	name varchar(255) not null,
	description varchar(255) not null,
	price double not null,
	type varchar(45) not null,
	country varchar(255) not null,
	start_date date not null,
	end_date date not null,
	free tinyint null,
	travel_agency_id varchar(255) null,
	customer_id varchar(255) null,
	constraint tour_ibfk_3
		foreign key (travel_agency_id) references travel_agency (id),
	constraint tour_ibfk_2
		foreign key (customer_id) references customer (id)
)
;

create index customerId
	on tour (customer_id)
;

create index travelAgencyId
	on tour (travel_agency_id)
;

create table travel_agent
(
	id varchar(255) not null
		primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	username varchar(255) not null,
	password varchar(255) not null,
	email varchar(255) not null,
	activation_code varchar(255) not null,
	role varchar(45) not null,
	position varchar(255) null,
	phone_number varchar(255) null,
	travel_agency_id varchar(255) not null,
	constraint travel_agent_travelagency_id_fk
		foreign key (travel_agency_id) references travel_agency (id)
)
;

create index travel_agent_travelagency_id_fk
	on travel_agent (travel_agency_id)
;

INSERT INTO mydb.tour (id, name, description, price, type, country, start_date, end_date, free, travel_agency_id, customer_id) VALUES ('12ef3a14-9a12-4ee9-9dd5-90a92161aec7', 'Sea', '18 days', 100.5, 'CRUISE', 'greece', '2018-11-30', '2018-12-12', 0, '65cd0390-576b-459c-818d-6d244661ff4a', '91ccd7a5-6446-4e8e-bfc6-010a66e12228');
INSERT INTO mydb.tour (id, name, description, price, type, country, start_date, end_date, free, travel_agency_id, customer_id) VALUES ('2be61a8a-3fa7-4f2d-a592-054de4f010dc', 'Tour by sea', 'Fast and furious', 100, 'CRUISE', 'tailand', '2000-10-09', '2000-10-09', 1, '65cd0390-576b-459c-818d-6d244661ff4a', '00000000-0000-0000-0000-000000000000');
INSERT INTO mydb.tour (id, name, description, price, type, country, start_date, end_date, free, travel_agency_id, customer_id) VALUES ('3de61a8a-3fa7-4f2d-a592-054de4f010dc', 'Bali', '2 person', 200000, 'HOTELRESTTOUR', 'italy', '2018-01-18', '2018-11-30', 1, '65cd0390-576b-459c-818d-6d244661ff4a', '00000000-0000-0000-0000-000000000000');

INSERT INTO mydb.travel_agency (id, name, count_tour, count_travel_agents) VALUES ('65cd0390-576b-459c-818d-6d244661ff4a', 'CoralTravel', 5, 10);

INSERT INTO mydb.travel_agent (id, first_name, last_name, username, password, email, activation_code, role, position, phone_number, travel_agency_id) VALUES ('851eee22-9170-4310-832f-bbb22c6d033b', 'Grisha', 'Moloch', 'travelAgent1', '11111', 'TravelAgent@gmail.com', 'qwdqscqwcdqwcd', 'TRAVELAGENT', '123123', '+375-29-567-23-23', '65cd0390-576b-459c-818d-6d244661ff4a');

INSERT INTO mydb.admin (id, first_name, last_name, username, password, email, activation_code, role) VALUES ('5be60162-f667-4f2d-a165-5697b6c1a3b5', 'Achik', 'Dmin', 'admin', '12345', 'admin@gmail.com', 'qwdqscqwcdqwcd', 'ADMIN');

INSERT INTO mydb.customer (id, first_name, last_name, username, password, email, activation_code, role, phone_number, card_number, date_of_birth, passport_info) VALUES ('00000000-0000-0000-0000-000000000000', 'null', 'null', 'null', 'null', 'null', 'null', 'GUEST', 'null', 'null', null, 'null');
INSERT INTO mydb.customer (id, first_name, last_name, username, password, email, activation_code, role, phone_number, card_number, date_of_birth, passport_info) VALUES ('91ccd7a5-6446-4e8e-bfc6-010a66e12228', 'Vova', 'Dinkevich', 'customer1', '11111', 'customer@gmail.com', 'qwdqscqwcdqwcd', 'CUSTOMER', '+375-29-567-23-23', '123123', '2000-10-09', '123123');
INSERT INTO mydb.customer (id, first_name, last_name, username, password, email, activation_code, role, phone_number, card_number, date_of_birth, passport_info) VALUES ('f16477b5-5571-472d-9d5d-6c77ddd75017', 'Sasha', 'Filippof', 'sallo', '12345', 'sashko@gmail.com', '79b02440-cc61-4d7f-b47a-fd21ec6072aa', 'CUSTOMER', '+375-25-234-23-23', '21234234123', '1999-12-12', '2e123de23d');