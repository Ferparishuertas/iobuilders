-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION regdb;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP TYPE _contact_channel;

CREATE TYPE _contact_channel (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = contact_channel,
	DELIMITER = ',');

-- DROP TYPE _corporation;

CREATE TYPE _corporation (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = corporation,
	DELIMITER = ',');

-- DROP TYPE _corporation_office;

CREATE TYPE _corporation_office (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = corporation_office,
	DELIMITER = ',');

-- DROP TYPE _corporation_office_contact_channels;

CREATE TYPE _corporation_office_contact_channels (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = corporation_office_contact_channels,
	DELIMITER = ',');

-- DROP TYPE _corporation_official_document;

CREATE TYPE _corporation_official_document (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = corporation_official_document,
	DELIMITER = ',');

-- DROP TYPE _email_address;

CREATE TYPE _email_address (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = email_address,
	DELIMITER = ',');

-- DROP TYPE _geographical_address;

CREATE TYPE _geographical_address (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = geographical_address,
	DELIMITER = ',');

-- DROP TYPE _messenger;

CREATE TYPE _messenger (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = messenger,
	DELIMITER = ',');

-- DROP TYPE _person;

CREATE TYPE _person (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = person,
	DELIMITER = ',');

-- DROP TYPE _person_contact_channels;

CREATE TYPE _person_contact_channels (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = person_contact_channels,
	DELIMITER = ',');

-- DROP TYPE _person_nationality;

CREATE TYPE _person_nationality (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = person_nationality,
	DELIMITER = ',');

-- DROP TYPE _person_official_document;

CREATE TYPE _person_official_document (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = person_official_document,
	DELIMITER = ',');

-- DROP TYPE _plain_user;

CREATE TYPE _plain_user (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = plain_user,
	DELIMITER = ',');

-- DROP TYPE _ref_contact_messenger_provider;

CREATE TYPE _ref_contact_messenger_provider (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = ref_contact_messenger_provider,
	DELIMITER = ',');

-- DROP TYPE _ref_contract_telephone_type;

CREATE TYPE _ref_contract_telephone_type (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = ref_contract_telephone_type,
	DELIMITER = ',');

-- DROP TYPE _ref_corporation_official_document_type;

CREATE TYPE _ref_corporation_official_document_type (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = ref_corporation_official_document_type,
	DELIMITER = ',');

-- DROP TYPE _ref_corporation_type;

CREATE TYPE _ref_corporation_type (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = ref_corporation_type,
	DELIMITER = ',');

-- DROP TYPE _ref_country;

CREATE TYPE _ref_country (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = ref_country,
	DELIMITER = ',');

-- DROP TYPE _ref_person_official_document_type;

CREATE TYPE _ref_person_official_document_type (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = ref_person_official_document_type,
	DELIMITER = ',');

-- DROP TYPE _telephone;

CREATE TYPE _telephone (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = telephone,
	DELIMITER = ',');

-- DROP TYPE _user_holder_corporation;

CREATE TYPE _user_holder_corporation (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = user_holder_corporation,
	DELIMITER = ',');

-- DROP TYPE _user_holder_corporation_office;

CREATE TYPE _user_holder_corporation_office (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = user_holder_corporation_office,
	DELIMITER = ',');

-- DROP TYPE _user_holder_person;

CREATE TYPE _user_holder_person (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = user_holder_person,
	DELIMITER = ',');

-- DROP TYPE contact_channel;

CREATE TYPE contact_channel AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(250),
	level_position int4);

-- DROP TYPE corporation;

CREATE TYPE corporation AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250),
	"type" int8);

-- DROP TYPE corporation_office;

CREATE TYPE corporation_office AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	is_headquarter bool,
	level_position int4,
	"name" varchar(255),
	coporation_id int8);

-- DROP TYPE corporation_office_contact_channels;

CREATE TYPE corporation_office_contact_channels AS (
	corporation_office_id int8,
	contact_channel_id int8);

-- DROP TYPE corporation_official_document;

CREATE TYPE corporation_official_document AS (
	id int8,
	country int4,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(250),
	level_position int4,
	valid_until time,
	value varchar(250),
	corporation_office_id int8,
	document_type int8);

-- DROP TYPE email_address;

CREATE TYPE email_address AS (
	email_address varchar(250),
	id int8);

-- DROP TYPE geographical_address;

CREATE TYPE geographical_address AS (
	country int4,
	postal_code varchar(150),
	address varchar(250),
	id int8);

-- DROP TYPE messenger;

CREATE TYPE messenger AS (
	service int8,
	user_code varchar(250),
	id int8);

-- DROP TYPE person;

CREATE TYPE person AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	birthdate date,
	middle_name varchar(250),
	"name" varchar(250),
	sex varchar(255),
	surname_1 varchar(250),
	surname_2 varchar(250));

-- DROP TYPE person_contact_channels;

CREATE TYPE person_contact_channels AS (
	person_id int8,
	contact_channel_id int8);

-- DROP TYPE person_nationality;

CREATE TYPE person_nationality AS (
	id int4,
	country int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(250),
	level_position int4,
	person_id int8);

-- DROP TYPE person_official_document;

CREATE TYPE person_official_document AS (
	id int8,
	country int4,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(250),
	level_position int4,
	valid_until time,
	value varchar(250),
	person_id int8,
	document_type int8);

-- DROP TYPE plain_user;

CREATE TYPE plain_user AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(500),
	login_alias varchar(255),
	login_email_address varchar(255),
	"password" varchar(255));

-- DROP TYPE ref_contact_messenger_provider;

CREATE TYPE ref_contact_messenger_provider AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250));

-- DROP TYPE ref_contract_telephone_type;

CREATE TYPE ref_contract_telephone_type AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250));

-- DROP TYPE ref_corporation_official_document_type;

CREATE TYPE ref_corporation_official_document_type AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250));

-- DROP TYPE ref_corporation_type;

CREATE TYPE ref_corporation_type AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250));

-- DROP TYPE ref_country;

CREATE TYPE ref_country AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250),
	alpha2 varchar(255),
	alpha3 varchar(255));

-- DROP TYPE ref_person_official_document_type;

CREATE TYPE ref_person_official_document_type AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	description varchar(2000),
	"name" varchar(250));

-- DROP TYPE telephone;

CREATE TYPE telephone AS (
	"type" int8,
	code varchar(250),
	id int8);

-- DROP TYPE user_holder_corporation;

CREATE TYPE user_holder_corporation AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	user_id int8);

-- DROP TYPE user_holder_corporation_office;

CREATE TYPE user_holder_corporation_office AS (
	user_holder_id int8,
	corporation_office_id int8);

-- DROP TYPE user_holder_person;

CREATE TYPE user_holder_person AS (
	id int8,
	created_date timestamp,
	creator varchar(250),
	last_modificator varchar(250),
	last_modified_date timestamp,
	user_id int8,
	person_id int8);

-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.hibernate_sequence OWNER TO regdb;
GRANT ALL ON SEQUENCE public.hibernate_sequence TO regdb;
-- public.contact_channel definition

-- Drop table

-- DROP TABLE public.contact_channel;

CREATE TABLE public.contact_channel (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(250) NULL,
	level_position int4 NULL,
	CONSTRAINT contact_channel_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.contact_channel OWNER TO regdb;
GRANT ALL ON TABLE public.contact_channel TO regdb;


-- public.person definition

-- Drop table

-- DROP TABLE public.person;

CREATE TABLE public.person (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	birthdate date NOT NULL,
	middle_name varchar(250) NULL,
	"name" varchar(250) NOT NULL,
	sex varchar(255) NOT NULL,
	surname_1 varchar(250) NOT NULL,
	surname_2 varchar(250) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.person OWNER TO regdb;
GRANT ALL ON TABLE public.person TO regdb;


-- public.plain_user definition

-- Drop table

-- DROP TABLE public.plain_user;

CREATE TABLE public.plain_user (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(500) NULL,
	login_alias varchar(255) NOT NULL,
	login_email_address varchar(255) NOT NULL,
	"password" varchar(255) NULL,
	CONSTRAINT plain_user_pkey PRIMARY KEY (id),
	CONSTRAINT uk_ba78m00m00c3vrnxrd6jbrfbl UNIQUE (login_alias),
	CONSTRAINT uk_hspbfml5ij1bk3bigd5adwbox UNIQUE (login_email_address)
);

-- Permissions

ALTER TABLE public.plain_user OWNER TO regdb;
GRANT ALL ON TABLE public.plain_user TO regdb;


-- public.ref_contact_messenger_provider definition

-- Drop table

-- DROP TABLE public.ref_contact_messenger_provider;

CREATE TABLE public.ref_contact_messenger_provider (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NULL,
	CONSTRAINT ref_contact_messenger_provider_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.ref_contact_messenger_provider OWNER TO regdb;
GRANT ALL ON TABLE public.ref_contact_messenger_provider TO regdb;


-- public.ref_contract_telephone_type definition

-- Drop table

-- DROP TABLE public.ref_contract_telephone_type;

CREATE TABLE public.ref_contract_telephone_type (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NULL,
	CONSTRAINT ref_contract_telephone_type_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.ref_contract_telephone_type OWNER TO regdb;
GRANT ALL ON TABLE public.ref_contract_telephone_type TO regdb;


-- public.ref_corporation_official_document_type definition

-- Drop table

-- DROP TABLE public.ref_corporation_official_document_type;

CREATE TABLE public.ref_corporation_official_document_type (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NULL,
	CONSTRAINT ref_corporation_official_document_type_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.ref_corporation_official_document_type OWNER TO regdb;
GRANT ALL ON TABLE public.ref_corporation_official_document_type TO regdb;


-- public.ref_corporation_type definition

-- Drop table

-- DROP TABLE public.ref_corporation_type;

CREATE TABLE public.ref_corporation_type (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NULL,
	CONSTRAINT ref_corporation_type_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.ref_corporation_type OWNER TO regdb;
GRANT ALL ON TABLE public.ref_corporation_type TO regdb;


-- public.ref_country definition

-- Drop table

-- DROP TABLE public.ref_country;

CREATE TABLE public.ref_country (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NULL,
	alpha2 varchar(255) NULL,
	alpha3 varchar(255) NULL,
	CONSTRAINT ref_country_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.ref_country OWNER TO regdb;
GRANT ALL ON TABLE public.ref_country TO regdb;


-- public.ref_person_official_document_type definition

-- Drop table

-- DROP TABLE public.ref_person_official_document_type;

CREATE TABLE public.ref_person_official_document_type (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NULL,
	CONSTRAINT ref_person_official_document_type_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.ref_person_official_document_type OWNER TO regdb;
GRANT ALL ON TABLE public.ref_person_official_document_type TO regdb;


-- public.corporation definition

-- Drop table

-- DROP TABLE public.corporation;

CREATE TABLE public.corporation (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	"name" varchar(250) NOT NULL,
	"type" int8 NOT NULL,
	CONSTRAINT corporation_pkey PRIMARY KEY (id),
	CONSTRAINT fkes80ypqniilgr8t9iaqg3v5fk FOREIGN KEY (type) REFERENCES ref_corporation_type(id)
);

-- Permissions

ALTER TABLE public.corporation OWNER TO regdb;
GRANT ALL ON TABLE public.corporation TO regdb;


-- public.corporation_office definition

-- Drop table

-- DROP TABLE public.corporation_office;

CREATE TABLE public.corporation_office (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(2000) NULL,
	is_headquarter bool NOT NULL,
	level_position int4 NULL,
	"name" varchar(255) NOT NULL,
	coporation_id int8 NOT NULL,
	CONSTRAINT corporation_office_pkey PRIMARY KEY (id),
	CONSTRAINT fkd837671sijpi21s4ssle6eqqc FOREIGN KEY (coporation_id) REFERENCES corporation(id)
);

-- Permissions

ALTER TABLE public.corporation_office OWNER TO regdb;
GRANT ALL ON TABLE public.corporation_office TO regdb;


-- public.corporation_office_contact_channels definition

-- Drop table

-- DROP TABLE public.corporation_office_contact_channels;

CREATE TABLE public.corporation_office_contact_channels (
	corporation_office_id int8 NOT NULL,
	contact_channel_id int8 NOT NULL,
	CONSTRAINT uk_nht4y5wwagxenn4ov7ycvt24r UNIQUE (contact_channel_id),
	CONSTRAINT fk1i3aiys1747pta374rc745dw5 FOREIGN KEY (corporation_office_id) REFERENCES corporation_office(id),
	CONSTRAINT fk6lan8cl6uvceorky4dwlgqt0g FOREIGN KEY (contact_channel_id) REFERENCES contact_channel(id)
);

-- Permissions

ALTER TABLE public.corporation_office_contact_channels OWNER TO regdb;
GRANT ALL ON TABLE public.corporation_office_contact_channels TO regdb;


-- public.corporation_official_document definition

-- Drop table

-- DROP TABLE public.corporation_official_document;

CREATE TABLE public.corporation_official_document (
	id int8 NOT NULL,
	country int4 NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(250) NULL,
	level_position int4 NULL,
	valid_until time NOT NULL,
	value varchar(250) NOT NULL,
	corporation_office_id int8 NULL,
	document_type int8 NOT NULL,
	CONSTRAINT corporation_official_document_pkey PRIMARY KEY (id),
	CONSTRAINT fk6f0p2qqdxfmqo65769vojhpcb FOREIGN KEY (document_type) REFERENCES ref_corporation_official_document_type(id),
	CONSTRAINT fkye0bd6fpkjbe6cefsjdl23ys FOREIGN KEY (corporation_office_id) REFERENCES corporation_office(id)
);

-- Permissions

ALTER TABLE public.corporation_official_document OWNER TO regdb;
GRANT ALL ON TABLE public.corporation_official_document TO regdb;


-- public.email_address definition

-- Drop table

-- DROP TABLE public.email_address;

CREATE TABLE public.email_address (
	email_address varchar(250) NOT NULL,
	id int8 NOT NULL,
	CONSTRAINT email_address_pkey PRIMARY KEY (id),
	CONSTRAINT fk6lnmdr95mogk9sa0213ax88tt FOREIGN KEY (id) REFERENCES contact_channel(id)
);

-- Permissions

ALTER TABLE public.email_address OWNER TO regdb;
GRANT ALL ON TABLE public.email_address TO regdb;


-- public.geographical_address definition

-- Drop table

-- DROP TABLE public.geographical_address;

CREATE TABLE public.geographical_address (
	country int4 NULL,
	postal_code varchar(150) NULL,
	address varchar(250) NOT NULL,
	id int8 NOT NULL,
	CONSTRAINT geographical_address_pkey PRIMARY KEY (id),
	CONSTRAINT fkfe11ulh4gg0rgh1ktw076007e FOREIGN KEY (id) REFERENCES contact_channel(id)
);

-- Permissions

ALTER TABLE public.geographical_address OWNER TO regdb;
GRANT ALL ON TABLE public.geographical_address TO regdb;


-- public.messenger definition

-- Drop table

-- DROP TABLE public.messenger;

CREATE TABLE public.messenger (
	service int8 NULL,
	user_code varchar(250) NOT NULL,
	id int8 NOT NULL,
	CONSTRAINT messenger_pkey PRIMARY KEY (id),
	CONSTRAINT fkn9gsdarwy0t0kux008aa1slqo FOREIGN KEY (id) REFERENCES contact_channel(id)
);

-- Permissions

ALTER TABLE public.messenger OWNER TO regdb;
GRANT ALL ON TABLE public.messenger TO regdb;


-- public.person_contact_channels definition

-- Drop table

-- DROP TABLE public.person_contact_channels;

CREATE TABLE public.person_contact_channels (
	person_id int8 NOT NULL,
	contact_channel_id int8 NOT NULL,
	CONSTRAINT uk_ayffiwra2b4clo2ccr0xusn4e UNIQUE (contact_channel_id),
	CONSTRAINT fk9qrndbr12rl6ynq0iecgapu9g FOREIGN KEY (person_id) REFERENCES person(id),
	CONSTRAINT fkqgd2uw0y6jftvd0f3opvmqdi0 FOREIGN KEY (contact_channel_id) REFERENCES contact_channel(id)
);

-- Permissions

ALTER TABLE public.person_contact_channels OWNER TO regdb;
GRANT ALL ON TABLE public.person_contact_channels TO regdb;


-- public.person_nationality definition

-- Drop table

-- DROP TABLE public.person_nationality;

CREATE TABLE public.person_nationality (
	id int4 NOT NULL,
	country int8 NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(250) NULL,
	level_position int4 NULL,
	person_id int8 NOT NULL,
	CONSTRAINT person_nationality_pkey PRIMARY KEY (id),
	CONSTRAINT fkbaoc4fb8c1f2of07m5k7uight FOREIGN KEY (person_id) REFERENCES person(id)
);

-- Permissions

ALTER TABLE public.person_nationality OWNER TO regdb;
GRANT ALL ON TABLE public.person_nationality TO regdb;


-- public.person_official_document definition

-- Drop table

-- DROP TABLE public.person_official_document;

CREATE TABLE public.person_official_document (
	id int8 NOT NULL,
	country int4 NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	description varchar(250) NULL,
	level_position int4 NULL,
	valid_until time NOT NULL,
	value varchar(250) NOT NULL,
	person_id int8 NOT NULL,
	document_type int8 NOT NULL,
	CONSTRAINT person_official_document_pkey PRIMARY KEY (id),
	CONSTRAINT fk40jeaobqlqhvc163r43dpl562 FOREIGN KEY (person_id) REFERENCES person(id),
	CONSTRAINT fknwnw5dw035j7cgahjm5bw651r FOREIGN KEY (document_type) REFERENCES ref_person_official_document_type(id)
);

-- Permissions

ALTER TABLE public.person_official_document OWNER TO regdb;
GRANT ALL ON TABLE public.person_official_document TO regdb;


-- public.telephone definition

-- Drop table

-- DROP TABLE public.telephone;

CREATE TABLE public.telephone (
	"type" int8 NULL,
	code varchar(250) NOT NULL,
	id int8 NOT NULL,
	CONSTRAINT telephone_pkey PRIMARY KEY (id),
	CONSTRAINT fk1r8xwrdi4oim9ljt1etglp30b FOREIGN KEY (id) REFERENCES contact_channel(id)
);

-- Permissions

ALTER TABLE public.telephone OWNER TO regdb;
GRANT ALL ON TABLE public.telephone TO regdb;


-- public.user_holder_corporation definition

-- Drop table

-- DROP TABLE public.user_holder_corporation;

CREATE TABLE public.user_holder_corporation (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	user_id int8 NULL,
	CONSTRAINT user_holder_corporation_pkey PRIMARY KEY (id),
	CONSTRAINT fkds1ti2unjnfslkwdtgc5kvr2r FOREIGN KEY (user_id) REFERENCES plain_user(id)
);

-- Permissions

ALTER TABLE public.user_holder_corporation OWNER TO regdb;
GRANT ALL ON TABLE public.user_holder_corporation TO regdb;


-- public.user_holder_corporation_office definition

-- Drop table

-- DROP TABLE public.user_holder_corporation_office;

CREATE TABLE public.user_holder_corporation_office (
	user_holder_id int8 NOT NULL,
	corporation_office_id int8 NOT NULL,
	CONSTRAINT fk3mwj2dggwtuaj3hxqc3gr93xl FOREIGN KEY (user_holder_id) REFERENCES user_holder_corporation(id),
	CONSTRAINT fkct7ag9kxn1je9u23wwsn0spsc FOREIGN KEY (corporation_office_id) REFERENCES corporation_office(id)
);

-- Permissions

ALTER TABLE public.user_holder_corporation_office OWNER TO regdb;
GRANT ALL ON TABLE public.user_holder_corporation_office TO regdb;


-- public.user_holder_person definition

-- Drop table

-- DROP TABLE public.user_holder_person;

CREATE TABLE public.user_holder_person (
	id int8 NOT NULL,
	created_date timestamp NOT NULL,
	creator varchar(250) NOT NULL,
	last_modificator varchar(250) NULL,
	last_modified_date timestamp NULL,
	user_id int8 NULL,
	person_id int8 NULL,
	CONSTRAINT user_holder_person_pkey PRIMARY KEY (id),
	CONSTRAINT fkrjelg2kh20j0gqmp1uufamic0 FOREIGN KEY (user_id) REFERENCES plain_user(id),
	CONSTRAINT fksex4dhem65eoif1laritjeto1 FOREIGN KEY (person_id) REFERENCES person(id)
);

-- Permissions

ALTER TABLE public.user_holder_person OWNER TO regdb;
GRANT ALL ON TABLE public.user_holder_person TO regdb;




-- Permissions

GRANT ALL ON SCHEMA public TO regdb;
GRANT ALL ON SCHEMA public TO public;
