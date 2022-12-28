
#Conditional Logic

## WHERE Clause 从句

--General Syntax
SELECT (which colums do you want to see in your result)
FROM (which table do these columns come from) 
WHERE(what criteria are we using to filter the data)

注意：Keywords must be UPPERCASE

## 一些概念 
**Predicates**(Questions in SQL)
> employee_id = 200; -- predicates

**Literals**（values in SQL are called literals.）
>200 - literals

如果是数字可以直接写
employee_od =200; employee = '200';
如果是 string value
last_name = 'King';
注意这里 case 也是敏感的，单引号不要用错了


**Expressions**(when we calculate a value )
>salary - 1000 < 4000 ;

![](images/2022-09-11-16-52-31.png)

addition +
substraction -
multiplication *
division /
modulus % (reture the remainder after a division)

Remaming Expressions in SQL

我们可以用 expression 来定义一个displayed name
```sql 
SELECT last_name,(salary * 12 ) AS "Yearly Salary" 
-- 如果我们用expression,我们都会重新定义 AS
```

## WHERE Clause - Conditions 5种
![](images/2022-09-11-16-58-08.png)

Number  
Varchar(series of characters/numbers/symbols)
Data(year-month-date)

### Comparison Operators 比较

![](images/2022-09-11-17-01-30.png)
日期也可以用这些数字.
比如:
'1970-01-12'<'2022=-8-24'
hire_date <'2022-08-09'

###  Range Test 范围
BETWEEN ...AND  
应用于：numbers , values, dates，character data

```SQL
WHERE column_name BETWEEN 'first_value'AND 'second_value'
WHERE employ_id BETWEEN 100 AND 200
WHERE birth_date BETWEEN '2022-03-01' AND '2023-03-01'
```


### Set Member 
A predicate verb used to test against a set of values
IN keyword is used to determine if a column's value is found within a list of values:
输出的数值不重要，而是比对的过程，相应的 ROW 和元素
```sql
WHERE employ_id IN (100,101,102,104,105);
```
> This means that the speed of the query is bound to the number of rows in the table and the size of the set it must be
compared against

Example: If you have 100 values in the IN and you have
10,000 rows in a table, it will make 10,000*100 comparisons!
Use with caution!

### Pattern Matching 

LIKE 
a predicate verb used to test against a matching pattern.

THE Pattern
- is a string that may include one or more wildcard character
- they are case sensitive 

'%' matches any sequence of 0-n characters;
'_'matches Exactly one characters

eg
```sql
WHERE last_name LIKE '%n'
--显示last_name 以 n 结尾的row
```
显示A 字母开头 LIKE ’A%‘
显示字符最后为son， LIKE'%son'
显示 first_name含有 2 个n的， LIKE’%n%n%'

练习 名字 A开头后面4位，而且son结尾
```sql
SELECT last_name
FROM employees
WHERE last_name LIKE 'A%son'
```

### NULL value Test 

**1 - IS NULL** 
used to test for NULL value

>注意没有等号 而是 IS
NULL 代表信息缺失，而不是 0 和空格

```sql
WHERE depart_id IS NULL
WHERE depart_id IS NOT NULL
```
**2 - NOT**
we can use NOT in front of many of our predicates for the opposite condition.

```sql
SELECT location_id,city,state_province,country_id
FROM locations
WHERE state_province IS NOT NULL;
```
![](images/2022-09-09-14-55-56.png)

```sql
SELECT *
FROM departments
WHERE manager_id IS NULL; 
--16

SELECT *
FROM employees
WHERE manager_id IS NOT NULL;
```

### Compounds AND/ OR

A AND B **both**    同时满足所有元素。
A OR B  **either** or **both** 满足至少任何一个元素即可。


```sql
SELECT *
FROM jobs
WHERE min_salary > 5000 AND max_salary < 10000;
```

```sql
SELECT * 
FROM departments
WHERE manager_id IS NOT NULL
AND location_id = 1700;
```



# Sorting 排序 ORDER BY

使用 WHERE query fliter 了一些 ROWS
如何按照某个column值的顺序排序


**ORDER BY**
DESC - decending
ASC - Ascending (default value if none provided)

注意
> ORDER BY 在 Query 最后使用
> used to sort our resulting set of rows based on column values.comes after any WHERE clasuse logic

**ORDER multiple columns** 重要
if A 元素有 same 的元素.这部分还可以继续排序。

**ORDER BY FORMUL**
可以用公式排序
计算的这个值必须被 renamed 
记得加**双引号**

```sql
SELECT last_name,(salary * 12) AS “Annual Salary”
FROM employees
ORDER BY “Annual Salary” DESC;
```

# Display Unique Results
DISTINT 
Used to remove duplicate rows containing the same column value
Always used in a SELECT for a specific column

```sql
SELECT DISTINCT first_name
FROM emplyees;
```

![](images/2022-09-11-20-19-40.png)
















