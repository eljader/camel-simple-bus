create schema ACSBUS;

create table ACSBUS.transformresult (
	sid integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	payload CLOB NOT NULL,
	PRIMARY KEY (sid)
);