drop schema projetpfe cascade;
drop sequence hibernate_sequence; 
create schema projetpfe;
create sequence hibernate_sequence;

/*CREATE TABLES */
CREATE TABLE projetpfe.citizen (
	citizen_id varchar(255) PRIMARY KEY,
	sick_since TIMESTAMP NULL
);
CREATE TABLE projetpfe.qrcode_covid (
	id_qrcode varchar(255) PRIMARY KEY
);
CREATE TABLE projetpfe.web_user (
	user_id SERIAL PRIMARY KEY,
	login VARCHAR(100) NOT NULL CHECK (login<>''),
	password VARCHAR(255) NOT NULL CHECK (password<>''),
	name VARCHAR(255) NOT NULL CHECK (name<>''),
	role VARCHAR(20) NOT NULL CHECK(role='doctor' OR role='establishment'),
	address VARCHAR(100) NULL CHECK (address<>'')
);
CREATE TABLE projetpfe.place (
	place_id SERIAL PRIMARY KEY,
	name VARCHAR(100) NULL CHECK (name<>''),
	description VARCHAR(200) NULL CHECK (description<>''), 
	id_establishment int references projetpfe.web_user(user_id) NOT NULL
);

CREATE TABLE projetpfe.visit (
	place_id int references projetpfe.place(place_id) NOT NULL, 
	citizen_id varchar(255) references projetpfe.citizen(citizen_id) NOT NULL, 
	entrance_date TIMESTAMP NOT NULL,
	PRIMARY KEY (citizen_id,place_id,entrance_date)
); 
