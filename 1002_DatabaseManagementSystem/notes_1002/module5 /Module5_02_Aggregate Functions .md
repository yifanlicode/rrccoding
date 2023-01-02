# Aggregate Function/GROUP BY /HAVING

[TOC]

## What is an Aggregate Function? 

- aggregate functions provide a means of evaluating an expression over a set of rows to reduce them to a single value.    处理多行结果到一个单值
- The other built-in functions operated on a single expression only.

> /ˈæɡrɪɡət / 聚合功能

Syntax

SUM（） 函数名， 参数 Parameter 必须是一个 column name, 返回是一个单值

```sql
SELECT SUM(Salary) AS "Total Salaries"
FROM   Employees;
//   791415.00  返回一个单值
```

**What happened?** 

●For every row in the table the parameter (**salary**) is being used by the function SUM(). 

●Each row’s salary is added together to make a total.

●The result is returned..

The returned value will use ALL of the parameter column’s values on every row of the entire table.



## Aggregate Functions



#### 1. SUM() 求和

**Totals** all numeric values in a specified column throughout all rows in a table.

```sql
SELECT SUM(Max_Salary) AS "Total Max Salaries"
FROM   Jobs;
```

**You may use multiple aggregate functions at the same time.**

**Note**: Once you use one aggregate function as a displayed column, you can only use other aggregates in the displayed columns.

```sql
SELECT SUM(Salary), MIN(Salary)
FROM   Employees;
```



#### 2.MIN() MAX（)  AVG（）

**MIN():**

- Returns the **smallest** value of the specified column by checking against all values of that column in the entire table.

- `SELECT MIN(Min_Salary) AS "Lowest Min Salary"` //     2008.00

**Max():**

- Returns the **largest** value of the specified column by checking against all values of that column in the entire table. 

- `SELECT MAX(Region_Id) AS "Largest Region ID"` //4

**AVG():**

- Returns the **average** value of the specified column by totaling all values of that column in the entire table and dividing by the number of rows.

- `SELECT AVG(Salary) AS "Average Salary"` //   7327.91667



#### 4.COUNT() & COUNT(*)  重点

Returns the count of **Non-Null** values in the specified column throughout the entire table.

返回表格中指定列的所有非null行的数量

```sql
SELECT department_names , COUNT(manager_ID) AS "Managed Departments"
FROM departments
ORDER BY departmant_name //11
```

Note:

- When counting on a column the NULL values are omitted by the COUNT function 

  > Notice how COUNT(Manager_Id) only counts the NON-NULL values.  
  >
  > Each non-null value is counted once, even if there are duplicates
  
  

**COUNT(\*)**

Returns the count of **all rows** in the table. 空不空都数

```sql
SELECT COUNT(*) AS "Number of Departments"
FROM   Departments;  //27
```



**COUNT() - With DISTINCT**

You can use the keyword **DISTINCT** inside the brackets.

```sql
SELECT COUNT(DISTINCT first_name) 
AS "Number of Unique First Names"
FROM   Employees;
```

Make a query that displays the last Employee ID to be used in the Employees table.

`MAX(employ_id) AS "last employee)_id"`



## GROUP BY



**GROUP BY** is a new keyword that allows us to perform aggregate functions on groups of rows.

>  GROUP BY是一个新的关键字，它允许我们对记录组执行聚合。

To use GROUP BY, we must specify a column name. 

> 要使用GROUP BY，我们必须指定一个列名。 

All rows that share the same value for the specified column will then form a subgroup.

> 所有与指定列的值相同的行将形成一个子组。

```sql
SELECT Region_Id, COUNT(*) AS "Countries in Region"
FROM Countries
GROUP BY	Region_Id;
```

**What’s happening:**

1. All countries with the same **Region_Id** will be **GROUPED** together. 一个地区的国家先被聚合起来
2. Unique values of region_id use the same variable to keep track of the results for their group. 调用 count 去数一个地区有几个国家
3. Once all rows are read, the aggregate function returns the value for each unique grouping. 数完之后去返回每个 group 的数量
4. In the above example **COUNT(\*)** returned the number of rows in each group.

练习：
List how many departments are located in  each location.

```sql
SELECT department_id ,COUNT(*) AS “Departments in locations”
FROM departments 
GROUP BY location_id
```

List each Country ID beside the count of the   locations in that country. Do not include a country id if it is NULL.

```sql
SELECT country_id,COUNT(*) AS "locations in countries"
FROM locations
WHERE country_id IS NOT NULL
GROUP BY country_id
```

**IMPORTANT NOTE:** 

> We place the **WHERE** clause before the * *GROUP BY**.

> This happens because we are filtering BEFORE we group!



We can use multiple columns in a GROUP BY.

```sql
GROUP BY	c.country_id, c.country_name;
```



练习

**Example**: Show the number of  locations for each country,   include the country name beside  each country id.

```sql
SELECT c.country_id, c.country_name,
       COUNT(*) AS "Number Of Locations"
FROM Countries c
JOIN 	Locations l 
  ON c.country_id = l.country_id
GROUP BY	c.country_id, c.country_name;
```



## HAVING（）

**WHERE** is used to filter rows

**HAVING** is used to filter groups

**For Example:**

Show regions with a count of their countries, but 
 only show the regions that have less than 7 countries.



**Example**: Only show the regions that have less than 7 countries

```sql
SELECT Region_Id,
       COUNT(*) AS "Countries in Region"
FROM Countries
GROUP BY Region_Id
HAVING COUNT(*) < 7;
```



**Solution:** Show all city names and the number of departments they have. Do not include the departments with the names “Retail Sales” and “IT Helpdesk”. Only show cities with more than 5 departments.

```sql
SELECT city,
       COUNT(*) AS "Departments in City"
FROM 	Departments d
JOIN 	locations l ON l.location_id = d.location_id
WHERE d.department_name NOT IN 
('Retail Sales','IT Helpdesk')
GROUP BY	l.city
HAVING COUNT(*) > 5;
```









##  ORDER BY()

**Note:** We can use an aggregate function in an expression as shown in the previous example.

We can also use aggregates within our **ORDER BY**:

```SQL
SELECT Region_Id,
       COUNT(*) AS "Countries in Region"
FROM Countries
GROUP BY Region_Id
HAVING COUNT(*) < 7
ORDER BY COUNT(*) DESC;
```



The ORDER in which SQL executes is roughly as follows:

1.**FROM**  Gets all the rows from the table.

2.**JOIN**  Gets rows from new table, applies ON  condition and constructs a new dataset. 

3.**WHERE**  Applies conditions to each row remaining.

4.**GROUP BY** Place each row in it’s appropriate grouping.

5.**HAVING**  When all groups formed, apply conditions

6.**SELECT** Determine data to be displayed.

7.**ORDER BY** Sort the result set.



## SUMMARY

●What is an aggregate function?

●What is the difference between COUNT() and COUNT(*)?

●What does GROUP BY do?

●Why and when do we use HAVING?