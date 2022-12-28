/**
 ** Name: Yifan li
 ** Assignment: 3
 ** Date: October 13th, 2022
 **/


-- 1.Create your own table with a minimum of 3 columns. 
-- You must use at least 3 different kinds of data types.

DROP TABLE Information;
CREATE  TABLE  Information (
    -- 记得新增行 都要加逗号
    student_id    NUMERIC(7)  NOT NULL,
    name          VARCHAR (50)  NOT NULL ,
    score         NUMERIC(4,2), 
    city          VARCHAR (50),  
    birth_date    DATE,
    
    --每一个 constraint 结束后都要加逗号
    CONSTRAINT InformationPK 
        PRIMARY KEY(student_id)
);


/* 2. Using your table from question 1: Create a minimum of 4 INSERTS.
On one of your INSERTs, do not specify all of your columns. 
You should write a simple SELECT after your INSERTs to see the new data.  */

INSERT  INTO  Information ( student_id ,  name ,  score ,  city ,  birth_date )
VALUES (1234300, 'Jocelyn',  89.33, 'New York', '1999-01-09' );

INSERT  INTO  Information ( student_id ,  name ,  score ,  city ,  birth_date )
VALUES (1234568, 'Matt', 78.50, 'Winnipeg', '1993-09-01' );

INSERT  INTO  Information ( student_id ,  name ,  score ,  city ,  birth_date )
VALUES (1234569, 'Jack', 98.45, 'Toronto', '1994-10-31' );

-- Missing the score column, so the score will be NULL in the table 
INSERT  INTO  Information ( student_id , name ,  city ,  birth_date )
VALUES (1234570, 'Rose', 'Vancouver',  '1999-01-01');


SELECT * FROM Information;

/* 3.Create an UPDATE statement that changes 3 or more columns. Only 1 row should be updated..
You should write a simple SELECT after your UPDATE to see the new data. */


UPDATE Information
SET 
	name = 'Joe',
	score = 99.99,
	city = 'Winnipeg'
WHERE student_id = 1234300;

SELECT * FROM Information WHERE student_id = 1234300;

/* Create a DELETE statement. This statement should only remove 1 row.*/

-- delete the row where the student_id is 1234993
DELETE FROM Information
WHERE student_id = 1234300;

-- check if the row is deleted
SELECT * FROM Information WHERE student_id = 1234300;

COMMIT;


/*5.CREATE the tables and any CONSTRAINTS specified for the Routes & Planes business rules above.
Create one valid INSERTs on each table. Create INSERT statements to violate…*/

-- create the table for the routes
DROP TABLE Routes;
CREATE TABLE Routes (
    routing_id CHAR(6) NOT NULL,
    length_of_route NUMERIC(2,1),
    departure_city_name VARCHAR(85) NOT NULL,
    arrival_city_name VARCHAR(85) NOT NULL,
    CONSTRAINT RoutesPK
        PRIMARY KEY (routing_id),
    CONSTRAINT route_length_positive
    CHECK (route_length > 0.0 AND route_length < 20.0)
);


-- create the table for the planes
DROP TABLE Planes;
CREATE TABLE Planes (
    plane_serial_number  NUMERIC(10)  NOT NULL ,
    plane_name  VARCHAR (100)  NOT NULL,
    fuel_capacity  NUMERIC(8,2),
    CONSTRAINT PlanesPK 
        PRIMARY  KEY (plane_serial_number)
);

-- create the table for the flights
DROP TABLE Flights;
CREATE TABLE Flights (
    plane_route_id   NUMERIC(5)  NOT NULL ,
    routing_id  CHAR (6)  NOT NULL ,
    plane_serial_number  NUMERIC (10)  NOT NULL ,
    departure_date  DATE  NOT NULL ,
    arrival_date  DATE  NOT NULL ,
    CONSTRAINT FlightsPK
        PRIMARY KEY (plane_route_id),
    CONSTRAINT FlightsFK1 
        FOREIGN KEY (routing_id) 
        REFERENCES  Routes (routing_id),
    CONSTRAINT FlightsFK2 
        FOREIGN KEY (plane_serial_number) 
        REFERENCES  Planes (plane_serial_number),
    CONSTRAINT FlightsCK1 
        CHECK (arrival_date >= departure_date) 
);

-- Create one valid INSERTs on each table.

INSERT INTO Routes (routing_id, length_of_route, departure_city_name, arrival_city_name)
VALUES ('AB1234', 5.5, 'Winnipeg', 'Toronto');

INSERT INTO Planes (plane_serial_number, plane_name, fuel_capacity)
VALUES (1234567890, 'Boeing 737', 100000.00);

INSERT INTO Flights (plane_route_id, routing_id, plane_serial_number, departure_date, arrival_date)
VALUES (12345, 'AB1235', 1234567890, '2021-10-10', '2021-10-11');

-- Create INSERT statements to violate the business rules.


-- one of the NOT NULL constraints
-- missing the routing_id, so the routing_id will be NULL in the table
INSERT INTO Routes (length_of_route, departure_city_name, arrival_city_name)
VALUES (3.0, 'Winnipeg', 'Toronto');


-- one of Foreign Key constraint
-- the routing_id is not in the Routes table, so the routing_id will be NULL in the table

INSERT INTO Flights (plane_route_id, routing_id, plane_serial_number, departure_date, arrival_date)
VALUES (32189, 'CD1235', 9898976678, '2021-10-10', '2021-10-11');


-- Any two of the Check constraints.

-- the arrival_date is before the departure_date, so the arrival_date will be NULL in the table
INSERT INTO Flights (plane_route_id, routing_id, plane_serial_number, departure_date, arrival_date)
VALUES (32178, 'AB1234', 1234567890, '2022-10-07', '2022-10-01');

-- the length_of_route is not between 0.0 and 20.0, so the length_of_route will be NULL in the table
INSERT INTO Routes (routing_id, length_of_route, departure_city_name, arrival_city_name)
VALUES ('AB1235', 30.0, 'Winnipeg', 'Toronto');

COMMIT;

















