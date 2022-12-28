/**
 ** Name: Yifan li
 ** Assignment: 5
 ** Date: November 23th, 2022
 **/

 /* 1.Make a query that displays all employees whose phone number starts
  with “515”. Display the result as a single column
  format the results as follows: “Steven King can be contacted at 515.123.4567” 21*/

SELECT CONCAT(first_name,' ',last_name,' can be contacted at ',phone_number) 
        AS "Employee Phone Number"
FROM employees
WHERE POSITION('515' IN phone_number) = 1;


/*2.show difference between the average minimum salary and average maximum salary in the Jobs table.1*/

SELECT AVG(max_salary) - AVG(min_salary) AS " Average Salary Difference"
FROM jobs;

/*3 Show all location's whose postal code is exactly 5 characters long.
Display the postal code and city name. When displaying the city name, remove spaces .9*/

SELECT location_id,postal_code, REPLACE(city, ' ', '') AS "City Name"
FROM locations
WHERE LENGTH(postal_code) = 5;

/* 4.Display all country names in the new format:  
The last 3 letters of the region name (from table regions)
combined with the last 3 letters of the country name (from table countries)
Order by the new country name in alphabetical order.  
Example: Americas & Canada = casada  25*/

SELECT CONCAT(SUBSTR(region_name, LENGTH(region_name)-2,3), 
              SUBSTR(country_name,LENGTH(country_name)-2, 3)) AS "New Country Name"
FROM countries c
JOIN regions r ON c.region_id = r.region_id
ORDER BY "New Country Name";


/* 5.Find all jobs  where there is only 1 employee  with that job. 
Display the job titles in ascending order. Note: You do not need the job_history table.10 */

SELECT j.job_title
FROM jobs j
JOIN employees e ON j.job_id = e.job_id
GROUP BY j.job_title
HAVING COUNT(e.job_id) = 1
ORDER BY job_title ASC;


/* 6. Show the count of employees who have the same job id. 
 USE AVG to average pay for that job 
 and show the last date someone was hired with that job. 
 Order the result by the largest number of employees, then order by highest average pay. 19 */

SELECT job_id, COUNT(job_id) AS "# of Employees", 
       LPAD ( CAST(ROUND(AVG(salary)) AS VARCHAR(8)), 8, '.')  AS "Average Pay", 
       MAX(hire_date) AS "Last Hired"
FROM employees
GROUP BY job_id
ORDER BY "# of Employees" DESC, "Average Pay" DESC;

/* 7.Display a count of all employees for each department. 
include employees with the Job ID of “IT_PROG” and “SA_REP”. 
You must show both the department id and department name beside the employee count. 
Only show the departments that have less than 3 employees.1*/

SELECT department_id,
       department_name, 
       COUNT(*) AS "Number of Employees"
FROM employees
JOIN departments
USING (department_id)
WHERE job_id IN ('IT_PROG', 'SA_REP')
GROUP BY department_id, department_name
HAVING COUNT(*) < 3;
 
/* Make a query that returns the first 3 characters of 
each employee’s last name. (Show their original last name in the query as well) */

SELECT last_name, SUBSTR(last_name,1,3) AS "Short LName"
FROM employees;

--Show only the Employees whose last name starts with the letter A:

SELECT last_name
FROM employees
WHERE POSITION ('A' IN 'last_name') = 1;










