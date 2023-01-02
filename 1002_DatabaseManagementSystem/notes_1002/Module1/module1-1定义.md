DBMS

# DB/DBMS 定义

### DATABASE 
定义:' An organized collection of structured information, or data, typically stored electronically in a computer system.''
> comes from the Oracle Corporation...

### DBMS 
定义:A DBMS is a software package that allows us work with data in our database.

IS A COMPUTER APP the installed on a computer
> The DBMS that we will use in this course is PostgreSQL 

A computer with running DBMS is called a SERVER
A Server receives and sends data to other APPS:
    - between computers over a network
    - between apps on the same computer


### Relational Database Model
a relational database is a database strucured to recognize relations among stored items of information.
关系数据库是一个数据库，用于识别存储的信息项目之间的关系。
- info is stored as simple rows and columns in tables of data ,like excel
- queries make it easy to insert/delete/update/filter/sort records of data

<!-- how about other Database Model
- document object-based model ,used by mongoDB and is often referred to as NOSQL
 -->


## TABLES

df: a table has a name and contains rows and columns.
- a column can be called an Attribute or a Field
- A ROW is also called a Record


### Tables(Entities实体)
- a table must have at least one column(Attribute )
- a table can have 0-n rows(Records)
- column order from left to right is defined when the table is first created
- tables can also be referred to as :Entities


### Column(Attributes)
a collection of attrbutes define the Entity
![](images/2022-09-11-20-35-29.png)
Attribute values can be:
1. simple or composite
2. stored or derived
3. a specific datatype value
4. null

#### simple attribute
the attribute value is not divisible into anything smaller.
ex: first name , year,age ,sin ,ID

#### composite attribute
the attribute's value can be divided into subparts with their own meaning
ex:fullname contains a first and last name
ex:birthdate contains year month day

#### stored attribute
this is the default type of attribute.
when there is no way to'calculate'the value,using anthor attributes in the database.
ex:birthdate  生日是猜不出来的,必须被定义

#### derived attribute
can be calculated from other attributes in database.
ex: age = today - birthdate

### datatype values
不同数据库的数据类型名称不同
attributes are restricted to a specific datatype value,defined at the time of the table creation.
ex: int double string boolean 

numbers 
- may contain decimals
- no letters or special characters allowed
- postgre SQL is a NUMERIC datatype

dates
ex birthdate
- contains : day month year hours minutes seconds
- postgre SQL is DATA or TIMESTAMP datatype

strings and characters
- a series of characters
- - postgre SQL is VARCHAR datatype

Null Values
there is no value here. the field is empty.
- not equales 0 or space 
- means nothing stored for this attribute
like
- a value exists,but not currently known
- a value may  not exist at all 

### Flat files
df:excel and similar data storage files are called
ex:XML JSON CSV  SIMPLE TEXT FILES

Flat files have no hierarchical design and are often stored as values separated by symbols
These types of files are still extremely useful, data is often sent between web pages in these formats
![](images/2022-09-11-20-55-13.png)

#### disvantages
- only 1 person can edit at one time
- duplicate data
- inconsisten data
- lack of data protection

#### advantages of a well-designed relatioonal database
- ability to handle huge volumes of data and multiple concurrent users
- maintains data integrity, consistency,security,and appreciable system performance 
- reduced data redundancy(duplication)
- reduced data entry,storage,and retrieval costs

## Primary keys PK

Relational databases use Keys to identify each row in a table and to link rows between tables.

Primary Key: a column (attribute) which uniquely identifies a single row in a table. 

Can also be a combination of two or more columns, in this case called Composite Primary Key.

To be considered a Primary Key:
- The column(s) cannot be null
- Must be a unique value (cannot repeat) within the table
- The value in the column should never change over time
- 
![](images/2022-09-11-21-27-26.png)

**Surrogate Keys**
Definition: A Surrogate Key is a column (attribute) which is created specifically for a table to be the Primary Key.

When this happens the value is often auto-generated and each new value is calculated by the system automatically.

Numbers and date time stamps are usually good options for surrogate key values.
![](images/2022-09-11-21-30-53.png)

cons vs pros
![](images/2022-09-11-21-32-23.png)

## TABLE RELATIONSHIPS
parent-child
a parent can have 0-n children
a child can have 1-n parents

parent is the table whose PK is being used in another table 
child is the table who references another table's PK

![](images/2022-09-11-21-37-34.png)

## foreign key FK
![](images/2022-09-11-21-35-09.png)
a FK is a column whose values and datatype match the primary key of another table

by default,foreign key values may contain duplicates and maybe NULL.
if PK is composite,the FK also be composite.


# Interact with PostgreSQL
we need an integrated development  environment IDE  集成开发环境 
such as PostgreSQL

PostgreSQL Benefits
- Open source
- Runs on all operating systems
- Extensible
- Follows SQL standard although there are some syntax differences

如何安装:https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

## ERD
 Entity Relationship Diagram(ERD) 
of the database we just created!

![](images/2022-09-11-21-43-30.png)