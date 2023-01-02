# Subqueries  子查询

[TOC]

## What is Subqueries

- a query that appears `WITHIN` another query
- Asking the database to answer 2 or more questions at the same time
  - where one question is answered and then the second questions's answer is dependent on the answer to the first question
  - 下一个搜索🔍建立在第一个🔍之上



 #### WHEN WE USE SUBQUEREIS

list all employees whose salary is above average

```sql
SElECT * 
FROM Empoyees
WHERE salary > (SELECT AVG(salary) FROM Employees);
```

Note:

> We put the subquery in brackets(parenthesis)
>
> the subquery returns 1 column and 1 value
>
> we can compare against a single row value with a < type operator



## Subquery Guidelines

When using subqueries(the inner query ) follow these guildelines:

1. use parenthesis; `*/*pəˈrenθəsɪs*/* `小括号  brackets

2. returen a **single column** （返回一个列）

3. do not use `ORDER BY`

4.  can return multiple rows or single rows.

   a. A single row can be used with comparsion operations:

   ` >, <, <=, >=, <>, IS NULL ,IS NOT NULL`

   b. Multiple row results use collection comparison such as : `IN , NOT IN `

*We will  not use subqueries with multiple column colunms, but it can be done .

**Single row Example:** Show all locations where the country  name is: **Canada**

```sql
SELECT *
FROM locations l
WHERE l.country_id = (SELECT c.country_id FROM countries c
      								 WHERE c.country_name ="Canada");
```

**Multiply row Example:**

Display department names *(there will be many)*, that have an employee with the last name of: **Smith**

```SQL
SELECT d.department_name 
FROM Departments d
WHERE d.department_id IN
			(SELECT e.department_id
			FROM	Employees e
			WHERE	 e.last_name = 'Smith');
```

**Note:**

> When multiple rows are returned, we must use **IN** or **NOT** **IN**
>
> This is because **d.department_id** must check against a **collection** of possible **e.department_id** values.Only one result because all of the Smiths work for the same department!



## Non - Correlated Subqueries

We have only seen examples of **non-correlated**ˈkɔːrəleɪtɪd subqueries.

The subquery portion is only executed **ONCE** and then the value is used by the outer query.

- The subquery portion can be run independently from the outer query. 可以独立运行   /ˈeksɪkjuːt/ 

- The database executes the **inner query** (subquery) **first**. 子查询的数据先运行 

- The **outer query** will execute **second** and compare each row’s department_id with the results of the inner query. 外部查询会在其后比较其数值
- We can execute the inner query without needing the outer query at all.



## Correlated Subqueries

Correlated subqueries are queries where the subquery portion is executed many times.  相关的子查询是指子查询部分被多次执行

The inner query (subquery) will **have a reference to the outer query**.

子查询和外部查询有关系，不能独立于外部查询运行

Therefore, the subquery portion **CANNOT be run independently** from the outer query. 

> Note:  Correlated Subquery always takes SIGNIFICANTLY LONGER to run than: 
>
> - A query that does not have a subquery or 
> - Has a non-correlated subquery.



**Example 1**: Find any job, who has an  employee with the max salary:

```sql
SELECT j.job_title
FROM jobs j
WHERE  j.max_salary =
       SELECT  MAX(e.salary)
       FROM employees e
       WHERE j.job_id = e.job_id;
```

The database executes the **outer query** **first**. 

	- The subquery **cannot** run first as the column j.job_id resides on the jobs table
	- The subquery contains an ‘Outer Reference’

For each row of the outer query, the inner query will execute!

The subquery contains an Outer Reference. Therefore it cannot execute on its own.



**Subqueries vs JOINs**

SQL subqueries can often be written as joins. 

It is up to you to determine which one is simpler to write and understand. 

**However, you should factor in efficiency and speed.**

SQL statements from **fastest to slowest** are:

1. **SELECT** from a single table

2. **Non-correlated** subqueries (AND usually SET operators)

3. **Joins**

4. **Correlated subqueries**



## EXISTS / NOT EXISTS

The `EXISTS` command tests for the existence of any record in a subquery, and returns true if the subquery returns one or more records.

EXISTS关键字检查一个子查询是否返回任何记录。(类似于COUNT(*))

**Example:** Show city names where the department is missing a manager:

```sql
SELECT l.city
FROM Locations l
WHERE EXISTS
	(SELECT * FROM	Departments d
  WHERE	 l.location_id = d.location_id
  AND d.manager_id IS NULL);

```

It does not matter which columns are returned in this subquery. The subquery columns will never be displayed to the screen.

- If rows are returned, the condition will evaluate to TRUE
- If no rows are returned, the condition evaluates to FALSE

Therefore, you should always speed the query up by hard coding a **literal** **value** instead:

```sql
SELECT l.city
FROM locations l
WHERE EXISTS
			(SELECT 1
       FROM departments d 
       WHERE  l.location_id = d.location_id AND d.manager_id IS NULL)
```

### **NOT EXISTS**

You can always use the **NOT** keyword to flip the results of your **EXISTS** subqueries:

```sql
SELECT l.city 
FROM Locations l
WHERE NOT EXISTS  
	(SELECT	1
   FROM	Departments d
   WHERE	 l.location_id = d.location_id
   AND d.manager_id IS NULL);
```

Now we will find all the cities who do have a manager.



## **Subqueries throughout a Query**

A subquery can be placed in many clauses on SQL statements. 

You can put a subquery anywhere you could put a column name or value.

You can even use a subquery instead of a table name.