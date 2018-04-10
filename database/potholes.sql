CREATE DATABASE potholes;

DROP TABLE pothole;

CREATE TABLE pothole
(
    pothole_id SERIAL NOT NULL,
    street_name varchar(200) NOT NULL,
    status_code varchar(10) NOT NULL,
    status_date timestamp NOT NULL,
    severity int NOT NULL,
    longitude decimal(16, 13) NOT NULL,
    latitude decimal(16, 13) NOT NULL,
    report_date timestamp NOT NULL,

    CONSTRAINT pk_pothole_id PRIMARY KEY (pothole_id)
);

INSERT INTO pothole (street_name, status_code, status_date, severity, longitude, latitude, report_date) VALUES ('Brianroad', 'reported', '20080203', 5, 123.1235891345, 534.9999999999999, '23431212');