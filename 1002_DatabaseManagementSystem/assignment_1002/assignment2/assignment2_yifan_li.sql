
/**
 ** Name: Yifan li
 ** Assignment: 2
 ** Date: September 30th, 2022
 **/


/* 1.Make a list of employee ID's and the country name their department is located in. 107records */

 SELECT 
    e.employee_id,
    c.country_name
 FROM employees e
 JOIN departments d
    ON  d.department_id = e.department_id
 JOIN locations l
    ON l.location_id = d.location_id
 JOIN countries c
    ON c.country_id = l.country_id;

--  2.Show all the Department Names, along with their manager's full names, job titles and salaries.
-- Department's without a manager not be shown.11records 

SELECT 
  d.department_name,
  m.first_name AS "Manager first_name",
  m.last_name AS "Manager first_name",
  j.job_title,
  m.salary
FROM employees m
JOIN jobs j
	ON j.job_id = m.job_id
JOIN departments d
	ON  m.employee_id = d.manager_id;

/* 3. Select all departments whose location is in the Europe Region.
Display the department name, city name, country name, and region name.
3records*/

SELECT 
	d.department_name,
	l.city,
	c.country_name,
	r.region_name
FROM departments d
JOIN locations l
	ON l.location_id = d.location_id
JOIN countries c
	ON c.country_id = l.country_id
JOIN regions r
	ON r.region_id = c.region_id
WHERE r.region_name = 'Europe';

 /* 4 shows the job histories of the employees with following id's(176, 200, 101, and 102).
Show the full name, job title, job ID, end date, and the current maximum salary of each job.
Order the results by Last Name in descending order and then order by End Date from oldest to newest.
7 records */

SELECT 
	e.first_name,
	e.last_name,
	j.job_title,
	j.job_id,
	h.end_date,
	j.max_salary
FROM employees e 
JOIN jobs j
 	ON j.job_id = e.job_id
JOIN job_history h
	 ON e.employee_id = h.employee_id
WHERE  h.employee_id IN (176,200,101,102) 
ORDER BY e.last_name DESC , h.end_date ASC;


 /* 5 Show all employees whose current job has a max salary of at least 9000.
Display the employee id, full name, job title and max salary.
Sort the results by the largest max salary first.
57 records */

SELECT 
	e.employee_id,
	e.first_name,
	e.last_name,
	j.job_title,
	j.max_salary
FROM employees e
JOIN jobs j
	ON j.job_id = e.job_id
WHERE j.max_salary >= 9000
ORDER BY j.max_salary DESC;

 /*6.Show all of the department managers that work in Seattle.
include their manager ID, full name, department name and the city name. 5records */

SELECT 
	d.manager_id,
	m.first_name AS "Manager first_name",
	m.last_name AS "Manager last_name",
	d.department_name,
	l.city
FROM employees m
JOIN departments d
	ON m.employee_id = d.manager_id
JOIN locations l
    ON l.location_id = d.location_id
WHERE l.city = 'Seattle';

 /* 7.Show the location ids and City names 
 all locations that do no have a department and are not located in Mexico. 15records*/

SSELECT
	l.location_id,
	l.city
FROM locations l
LEFT JOIN countries c
	ON c.country_id = l.country_id 
LEFT OUTER JOIN departments d
	ON l.location_id = d.location_id 
 WHERE d.location_id IS NULL AND c.country_name <> 'Mexico' ;
	
 /* 8.Using a SET operator, Display all names that are used both as a last name and a first name.
Example:  Taylor Grant, Winston Taylor 2records */

SELECT 
e1.first_name
FROM employees e1
INTERSECT
SELECT 
e2.last_name
FROM employees e2;


 /* 9.Display country name and city name.
Only show countries without a city and cities without a country.
 13records*/

SELECT
	c.country_name,
	l.city 
FROM countries c
FULL OUTER JOIN locations l
	ON c.country_id = l.country_id 
WHERE c.country_id IS NULL or l.city IS NULL;





