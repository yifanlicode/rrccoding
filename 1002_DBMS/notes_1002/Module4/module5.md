
Built-in Functions


# What is a Function?
A predefined block of SQL code
May take 0 or more parameters
Usually returns a value


### UPPER
```sql
SELECT first_name, UPPER(first_name) AS "FIIRST NAME"
FROM   Employees
WHERE  employee_id = 200;
```
Function Name UPPer 
parameter/pəˈræmɪtər/   需要是 String


A lot of times functions need some information to do its job. The UPPER function converts a word (string) to upper case but if we didn't give the function a word to convert then the function wouldn’t know what it needs to convert. 

**IMPORTANT NOTE: We should ALWAYS rename a displayed column if we are using a function or an expression:**

Tip:  When choosing a name, use one that is intuitive for others to understand.

名字需要 user friendly   = intuitive  /ɪnˈtuːɪtɪv/
