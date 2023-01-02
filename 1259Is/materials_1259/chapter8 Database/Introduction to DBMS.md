# Introduction to DBMS



### Data Model 

•Structures and access techniques provided by a particular database management system (DBMS) are called its **data model**

•Each model had its advantages and its disadvantages

•Three primary Data Models (in order of introduction)

​	•Heirarchical

​	•Network

​	•Relational

•In many ways the relational data model represented an attempt to simplify the earlier data models



Hierarchical and Network Data Models 

- Extremely powerful and capable models
- Very hard to learn and use

Relational Model

- Very easy to learn and use
- Cost of easy to use is that of performance



### **Relational Data Model**

#### *RDM*

-  A relational database is a database where all data visible to users is organized strictly as tables of data values and where all database operations work on these tables.

- In this model information is stored in a database as simple row/column tables of data

#### TABLE

- A table is a rectangular object with rows and columns( attribute)
- Each row of the table contains exactly one data value or NULL
- In each column of a table, all of the data values in that column have the same type. which is written as a heading at the top of the column
- The columns of a table have a left-right order. That is defined when the table is first created.
- The order of the columns has no effect when any action is done against the table



- Each table must have at least one column
- Almost all commercial DBMS products impose maximum of 255 columns per table
- A table can have zero or more rows
- A table with zero rows is called an empty table
- Order of the rows is not important in a table. 
- Most relational DBMSs either do not impose any limit on the number of rows or their limit is a very large number 
- A common limit is approximately 2 billion rows

##### Columns (or Attributes)

- Are the basic building blocks of a row 
- A collection of attributes on a row define what is known as an entity

Attributes can be:

- Simple or Composite 	and/or

  - Simple  Attributes that are not divisible

  - Composite Attributes ◦C

    > can be divided into smaller subparts which represent more basic attributes with independent meaning. For example: date

- Stored or derived	and/or

  - •Stored •Attributes that are fixed and does not have to be calculated
  - Derived ◦Attributes that can be derived from other attributes either from the same table or other tables. 

- NULL

  - •Not Applicable •A particular row does not have an applicable value for an attribute
  - •Unknown •Missing (value exists but not known) •Not Known (existence is not sure)

##### PK

Df ◦*A primary key is a column (attribute) or combination of two or more columns (attributes) that uniquely identifies each row of a table.* If the primary key contains two or more columns, it is called a composite primary key

Requirements for a column(s) to be considered a primary key:

- The column(s) cannot ever be null
- Each row has a unique (different) value 
- The same value(s) cannot repeat
- The value in the column cannot (or should not) change
-  Typically numbers and/or dates are the best data type choice
- If character data types are used, they should be specially designed to be used as a Primary Key
  Otherwise values may change or be duplicated ‘Names’ and ‘Descriptions’ are poor choices



##### Surrogate Primary Key

Definition: A column that is added to a table to be the primary key and which will contain a value that has no special meaning for the business.  

- This value is normally determined by the system when data is added to the table.
- This column is only used to physically store the data – user areas likely not even aware the column exists.
- Surrogate primary keys typically consist of incremental numbers or current date/times

**Advantages of surrogate primary keys**

- Guaranteed unique as it is determined by the system
- Since users do not specify the value, spelling errors are eliminated
- Simplify Data model
  - Tables with composite primary keys can be set up with a surrogate key (single column)
  - Attributes that would have been the primary key become regular attributes

**Disadvantages of surrogate primary keys**

- Introduces extra storage on the database

- Meaningless values make use outside the data model worthless
  Users will still use their data to identify information

- Processing required to determine the next unique value are required

  

##### Relationships

Tables rarely exist by themselves, they usually have a relationship with one or more other tables

- Relationships are expressed as ‘Parent’-’Children’
- A parent normally has zero or more children
- A child normally has zero or more parents 

The Primary Key column (Office) always indicates the parent side in the relationship

##### **Foreign Key**

Definition: Foreign key is a column (or combination or two or more columns) whose value matches the primary key of a table

Together, primary key and the foreign key make the parent/child relationship in relational data models

Note: 
Primary keys are always located in the ‘Parent’
Foreign Keys are always located in the ‘Child’