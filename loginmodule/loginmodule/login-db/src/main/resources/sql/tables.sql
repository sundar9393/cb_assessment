DROP TABLE IF EXISTS CONSUMER CASCADE;
CREATE TABLE CONSUMER(id SERIAL, firstname VARCHAR(30) NOT NULL, lastname VARCHAR(30) ,
mobile_number VARCHAR(30) UNIQUE NOT NULL, role VARCHAR(30), address VARCHAR(30), PRIMARY KEY(id));