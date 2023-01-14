

/* 1. Display the country whose country ID is AR and region id is 2
Columns to show : Country Name.*/

-- Keywords must be UPPERCASE
-- retrieve data from tables
-- which columns do you want to see in your result
SELECT country_name

-- From indicates which table to fetch the rows
-- which table do these columns come from

FROM Countries
-- WHERE Clause what criteria are we using to filter the data
-- region_id = 2 is a predicates, 2 - literals
WHERE country_id = 'AR' AND region_id = 2;



/* 2.Display all countries that cotain at least 2 words
Columns to show : country name */

SELECT country_name 
FROM Countries
-- a predicate verb used to test against a matching pattern.
-- '%' matches any sequence of 0-n characters;
WHERE country_name LIKE '% %';


/* 3.display all locations whose country ID is either:US,CA or MX 
Columns to show:city,state/province,country id
Order the result by Country ID in alphabetical order */

SELECT city,state_province,country_id
FROM Locations

-- we can also use predicate IN
-- OR  either or both
WHERE country_id ='US' OR country_id ='CA' OR country_id ='MX'

-- sort our resulting set of rows based on column values.
-- comes after any WHERE clasuse logic
-- DESC - decending
-- ASC - Ascending (default value if none provided)
ORDER BY country_id ASC;


/* 4.Display all jobs with a Job ID that matches this format: starts with AD followed by EXACTILY 5 characters.
Columns to show:JOB ID.*/

SELECT job_id
FROM Employees
-- '_'matches Exactly one characters;
WHERE job_id LIKE 'AD_____';

/* 5.Display all departments sorted by their location in descending order.When multipley departments are located at the same location ID,show their names in alphabetical order. 
Columns to show：Location ID and department Name */

SELECT location_id,department_name
FROM Departments
ORDER BY location_id DESC,department_name ASC;


/* 6.Display all Employees who were hired in 2008.
Columns to show: Employee ID, First and Last name, and the hire date.
Order the result by oldest hire date to newest.*/

SELECT employee_id,first_name,last_name,hire_date
FROM Employees
-- Range Test
WHERE hire_date BETWEEN '2008-01-01'
				AND '2008-12-31'
ORDER BY hire_date ASC;


/* 7.Display all Employees (if any) whose last name starts with the first letter of your last name. 
Columns to show: Employee ID, First and Last name.
displayed by first name in alphabetical ordering.*/

SELECT employee_id,first_name,last_name
FROM Employees
WHERE last_name LIKE 'Y%'
ORDER BY first_name ASC;


/* 8.Display all Departments without managers whose name contains the word "Sales".
Columns to show: Department Name. 
Results should be displayed by Department name in reverse alphabetical order */

SELECT department_name
FROM Departments
-- used to test for NULL value
WHERE manager_id IS NULL
-- A AND B both
	AND department_name LIKE '%Sales%'
ORDER BY department_name DESC;


/* 9.Show the job history of all people whose start date is before the year 2000 or those people with a job id of either
MK_REP or SA_REP(regardless of if they started before 2000).
Columns to show: Employee ID, Start Date and Job ID.
Displayed by the oldest start date first.*/ 


SELECT employee_id,start_date,job_id
FROM Job_history

-- comparison less than
WHERE start_date < '2000-01-01'
	  OR (job_id = 'MK_REP' OR job_id ='SA_REP')
ORDER BY start_date ASC;


/* 10.Show all jobs where the max salary remains under 10,000 even with a 25% increase.
Columns to show: Job Title, Original Max Salary, New Max Salary after a 25% increase.
The results should be displayed based on the lowest new max salary first.*/

-- use AS to rename a displayed name
SELECT job_title,max_salary,(max_salary * 1.25) AS "new_max_salary"
FROM Jobs
-- use comparison operators to modify a displayed column
WHERE (max_salary * 1.25) < 10000
ORDER BY "new_max_salary" ASC;