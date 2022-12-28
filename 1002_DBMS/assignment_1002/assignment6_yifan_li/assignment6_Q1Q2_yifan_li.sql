/**
 ** Name: Yifan li
 ** Assignment: 6
 ** Date: December 6th, 2022
 **/


/* Q1: Create a View to show the city name of any location that has a department. 
Only show the city name once in the results.  Call this view: Department_Locations
*/

CREATE VIEW  Department_Locations
AS 
      SELECT DISTINCT city
      FROM locations l
      WHERE EXISTS (SELECT * FROM departments d WHERE l.location_id = d.location_id);  

/* display the View*/
SELECT * FROM Department_Locations;


/*2.show all the first and last names of managers and the count of their employees.
 Order the result by the highest number of employees first.*/

CREATE VIEW Manager_Employee_Counts
("First Name","Last Name","Employee Count")
AS 
SELECT first_name, last_name, 
       (SELECT COUNT(*) FROM employees e 
       WHERE e.manager_id = m.employee_id)  
        AS "Number_of_Employees"
FROM employees m
ORDER BY "Number_of_Employees" DESC;

/* display the View*/
SELECT * FROM Manager_Employee_Counts;























