
[toc]

#SQL BASICs

## SQL definition

SQL structured query language

language are syntax driven:
- what we say
- what order we say it

SQL allows us to manipulate date stored in a relational database managment system.

## SQL history
![](images/2022-09-11-21-57-18.png)

## SQL used to
- Create the database
- Create the Tables in a database
- Insert the rows into a table
- Retrieve and maintain data in the tables
- Add/Remove users from the database
- Enforce security and much more!




## DDL DML
### DDL 
data definition language ddl
- used to Modify The Structure of [database](https://www.rrc.ca/explore/program/full-stack-web-development/)
- like :
  - DROP
  - ALTER
  - CREAT

### DML  
data manipulation language
- used to Manipulate Data within the structure
- like
  - SELECT
  - UPDATE
  - INSERT
  - DELETE

#### SELECT
lets you retrieve data from tables
 - FROM 
 - WHERE
 - ORDER BY
 - GROUP BY AND HAVING

##### Commenting
```sql
--  for single lines
/* for 
multiple lines */ 
```

##### SELECT
```SQL
SELECT * 
-- asterix symbol 
-- * is a wild card value ,meaning all columns will be returned
FROM regions;
-- From indicates which table to fetch the rows
-- the semicolon indicates this is the end of our query;
```
###### RENAME Columns
AS
```sql
SELECT region_id AS "Region id" ,
       region_name AS "Region name"
FROM Regions;
```
![](images/2022-09-11-22-09-35.png)

![](images/2022-09-11-22-10-07.png)

