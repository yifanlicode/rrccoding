## Q3.Answer the following in your own words



### PART A

1. **The benefits of Views versus Tables?**

Q : 

(1) View  is a virtual table, does not occupy storage space.

(2) View  created dynamically when the view is referenced.

The view created from other real tables, when updated with time, the table changes, our view of the contents of the response is actually changing. 

(3)Views are used to simplify complex queries.

2. **The difference between a correlated query and non-correlated query?**

Q : A correlated query is a query that uses a subquery that references a column from the outer query.A correlated query executed once when the outer query executes one row. 

A non-correlated query is a query that uses a subquery that does not reference a column from the outer query. It is executed once in total and the value is passed to the outer query when it is finished.  Therefore, non-correlated query are more efficient than correlated query.

3. **Explain why a subquery would be used?**

Q : A subquery is a query that uses the result of one select query as a condition for another select query.Subqueries are used to return data that is used in the outer query.

SQL subqueries are often used in more complex query operations. Typically, there is one main enclosing query and one or more subqueries nested within the enclosing query.

You can use a subquery in a` SELECT`,` INSERT`, `DELETE`, or `UPDATE` statement to perform the following tasks:

- Compare an expression to the result of the query.
- Determine if an expression is included in the results of the query.
- Check whether the query selects any rows.



### Part B

1. **Describe the difference between a NoSql database and a relational database.**

Q : SQL databases are relational databases. This means that data is organized into tables and each table has a specific structure. Tables are connected to each other by relationships. This makes SQL databases very powerful in storing data that needs to be accessed in a specific way.

NoSQL databases are non-relational databases. This means that data is stored in a collection of documents. Therefore, they are better suited for storing data that does not need to be accessed in a specific way.

One of the main differences between SQL and NoSQL databases is how they scale. 

SQL databases use a vertical scaling approach,  noSQL databases use a horizontal scaling approach.
SQL databases are typically more expensive to maintain than NoSQL databases. 
SQL databases are also typically more complex than NoSQL databases. This is because SQL databases must follow ACID rules, which can make them slower and more complex.

2. **Describe a general scenario where NoSql would be a better choice than a relational database.**

Q : NoSql is a better choice than a relational database when you need to store large amounts of data.

NoSQL is versatile. It is best suited for data with uncertain requirements. Typical usage scenarios are social networking, customer management, and web analytics systems.

3. **Describe a general scenario where a relational database would be a better choice than NoSql.**

Q : A relational database is a better choice than NoSql when you need to store data that is related to each other.SQL is precise. It is best suited for well-defined projects with precise criteria. Typical usage scenarios are online stores and banking systems.