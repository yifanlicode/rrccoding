## **What is a View?**

●Views are **virtual tables** formed by the result of a query.

○You can use **any** **SELECT** query!

●Views are created and dropped just like tables.

●View can be queried as if they are a table.



**TRY IT!** Create this view that only shows employees by their full name in a single column:

```sql
CREATE VIEW Employee_Register
AS 
	SELECT(e.first_name || '' || e.last_name) AS "FULL NAME"
	FROM Employees e;
```



**TRY IT!** Once the above code is executed, query it like a table:

```SQL
SELECT *
FROM Employee_Register;
```



### RENAME A VIEW



```sql
CREATE VIEW Employee_Register2
("employeeID", full_name)
AS
  SELECT employee_id, 
      	(e.first_name || ' ‘ 
		|| e.last_name ) AS "Full Name"
  FROM Employees e;
```

**Note:** **employee_id** becomes **employeeID****"Full Name"** becomes **full_name**
 **Note2:** employeeID in quotes because we want to show ID in upper case



### DROPPING A VIEW

To delete the view, you can **DROP** it with this syntax:

```sql
DROP VIEW View_Name_Here;
```

If you want to replace your old view, you can use this

```sql
CREATE OR REPLACE VIEW View_Name_Here
AS … ;
```

###  Execution Views

When executing a query on a **VIEW**, the SQL **inside** the view must be **materialized** at the time of execution. *(Runs the* **SELECT** *when the view was created and builds its results)*

当在一个VIEW上执行查询时，视图内的SQL在执行时必须是物化的。(在创建视图时运行SELECT并建立其结果)

The SQL that queried the view can then be executed and queried against the **source data** *(data from the actual tables).*

然后可以执行查询该视图的SQL，并对源数据（来自实际表的数据）进行查询。

In other words, the data inside a view is not saved or cached in any way.Therefore there is a lot of overhead when querying a view.

换句话说，视图中的数据不会以任何方式被保存或缓存。因此在查询视图时有很多开销。