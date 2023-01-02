##  Built-In SQL Functions 

### OUTLINE 

[TOC]

### What is a function

- a predefined block of SQL code
- may take 0 or more parameters
- usually returns a value
- **Functions can be placed anywhere that a column or value can be placed:**

**Syntax** 

```sql
SELECT first_name, UPPER(first_name) AS "First Name"
FROM   Employees
WHERE  employee_id = 200;
```

`upper` is the function name; `first_name` is the parameter

- We should ALWAYS rename a displayed column if we are using a function or an expression: 重命名很重要，需要双引号
- When choosing a name, use one that is intuitive */*ɪnˈtuːɪtɪv*/`易于理解的` for others to understand. name need  more than one word require double quotes . 

### 一.Character manipulation 字符操作

请注意，UPPER（‘jack') ,UPPER(first_name) 都是可以的



#### 1. UPPER LOWER 大小写

**Lower Case:** Converts a parameter value into all lower case letters.

实际用法：比如判断条件的时候，避免大小写敏感

**Syntax Example**:```LOWER('rEd RiVER') ``` Returns the value: `red river`

```sql
SELECT first_name
FROM Employees 
WHERE LOWER(first_name) = 'Jennifer';
```



#### 2. INITCAP  首字母大写 

**Initial Capital:** The first letter in each word will be capitalized, while the other letter will become lower case.

**Syntax Example:** `INITCAP('rEd RiVER')`

Returns the value: **Red River**



#### 3. SUBSTR  返回部分值

**Substring**: returns a portion of a value.

Syntax

```sql
SUBSTR('1st Parameter value',
       2nd Parameter start 开始位置,
       3rd Parameter return 从开始位置数几位结束)
```

- **1st Parameter** ：The value we start with.

- **2nd Parameter:** A number indicating which character position to start from.

- **3rd Parameter:** A number indicating how many characters the result will contain. *(defaults to the value’s character length when omitted)*

Example:

```sql
SELECT SUBSTR('rEd RiVER',1,3)
```

Returns : value `rEd`

If you use a **Negative Number** for the starting character, SQL will count backwards from the left of the string

> This is not very useful and most likely should be avoided.

**Example:**

```sql
SELECT SUBSTR('rEd RiVER', -1,4)
```

Return : rE   -1 0 1 2 

举例：

Make a query that returns the first 3 characters of  each employee’s last name. 

```sql
SELECT last_name, SUBSTR(last_name,1,3) AS "Short LName"
FROM Employees;
```



#### 4.POSITION  定位 0-n

 **Position:** Locate one or more characters within a value.

**Returns a number** that represents the character position where the sought value was located (If not found a zero is returned).

```SQL
POSITION('你寻找的值’ IN 'value_to_search_within’)
```

举例：

```sql
SELECT POSITION ('R' IN 'rEd RiVER'))
```

Return : 5

举例实际表格中的用法：

Show only the Employees whose last name starts with the letter A:

```sql
SELECT first_name, last_name
FROM Employees
WHERE POSITION('A' IN last_name) = 1
```

#### 5. LENGTH  字符长度

Display only the employees who have a first name with more than 8 characters:

```sql
SELECT first_name, last_name
FROM Employees
WHERE LENGTH(first_name) > 8;
```

Make a query that returns only Employees whose first and last name combined is less than 10 characters long.

```
SELECT first_name,last_name
FROM Employees
WHERE (LENGTH(first_name)+LENGTH(last_name)) < 10 ; 

```

#### 6.LPAD(LEFT)  RPAD(RIGHT) 特定字符填充

These padding functions are used to pad the left or right side of a string value with a specific set of characters. This function is useful for formatting output.

这些填充函数用于用一组特定的字符来填充一个字符串值的左边或右边。这个函数对格式化输出很有用。

**1st Parameter** The value we want to format. 想要格式化的值。

**2nd Parameter **  number used to determine the maximum size of the returned output.  返回值是几位的（最大）

**3rd Parameter** A single character used to pad the original value to reach the maximum size. 填充符号

```SQL
SELECT LPAD('RED',6,'*')
```

 Returns left padding: ***Red

![image-20221128122221507](/Users/liyifan/Library/Application Support/typora-user-images/image-20221128122221507.png)

#### 7.TRIM   删除空格

**Takes a value and returns it with both leading and trailing padding characters removed.**接受一个值并返回该值，并删除前导和结尾填充字符。

```sql
SELECT TRIM('  my value  ')  //'my balue'
```

**LTRIM**

**Takes a value and returns it with leading padding characters removed.**

```sql
SELECT LTRIM('  my value  ') //'my value   '   
```

**RTRIM**

**Takes a value and returns it with trailing padding characters removed.**

```sql
SELECT RTRIM('  my value  ') // '   my value'
```



#### 8.CONCAT 聚合 ||

**Takes in 2 values and returns them both together as a single value.**

```sql
SELECT CONCAT('my','value') //myvalue
```

**We can use 2 pipe symbols** **||** to perform string concatenation in SQL. 

> This may be easier than using the CONCAT function.
>
>  Different languages use different symbols for this...

```sql
SELECT ('my' || 'value') // myvalue
```

Example

```sql
SELECT (first_name || ' ' || last_name) AS "Full Name",
		 employee_id
FROM Employees;
```

#### 9.REPLACE 替换

**Finds and replaces text within a string.**

```sql
SELECT 
REPLACE('replace the space with underscore', ' ' , '_')
```

Returns: **replace_the_space_with_underscore**  空格换为下划线

![image-20221123234050125](/Users/liyifan/Library/Application Support/typora-user-images/image-20221123234050125.png)

#### 10.**TRANSLATE**  查找替换

**Finds and replace specific** **characters** based on a pattern within a string.

```sql
SELECT TRANSLATE('Hello','Ho','Ys')
```

Returns: **Yells**

 All ‘**H**’s are replaced by ‘**Y**’s. All ‘**o**’s with ‘**s**’s.

>  The replacement string must have at least one character in it, or **TRANSLATE** will return null` 必须有至少一个字符 否则会返回 null 

```sql
TRANSLATE('Hello World!',' !','_')
```

Returns: **Hello_World**

The space is replaced with an underscore.

However, the exclamation point does not have a corresponding replacement string and therefore is replaced with **nothing**…

```sql
TRANSLATE('Hello World!','1 !l','1')
```

Returns: **HeoWord**

The 1 is replaced with a 1, so nothing happens.

However, all other characters *(space, exclamation mark, and the letter l)* are replaced with **nothing**…

### 二  Number Manipulation

####  1.ROUND 余数

Rounds a number off to the nearest specified digit.

> 将一个数字四舍五入到最近的指定数字。

- 1st Parameter: The original value.原始值。

- 2nd Parameter: An optional value used to determine which digit to round to. 
  - 一个可选的值，用于决定四舍五入到哪一位数。
  - Defaults to 0 if no value is present. 如果没有数值，默认为0。

Positive numbers will round to a decimal. 正数将四舍五入到一个小数。
Negative numbers will round to a specific whole number position 负数将四舍五入到一个特定的整数位置

![image-20221124000237372](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124000237372.png)



#### 2.TRUNC 移除最近数字（非round)

Removes numbers to the nearest specified digit (does not round).

将数字去除到最近的指定数字（不四舍五入）。

- 1st Parameter: The original value.

- 2nd Parameter: An optional value used to determine which digit to truncate to. 
  - Defaults to 0 if no value is present. 一个可选的值，用于决定截断哪一位数
  - Positive numbers will go to a decimal. 正数将转为小数。
  - Negative numbers will go to a whole number.负数将转为整数。

![image-20221124000459108](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124000459108.png)

#### MOD 计算除法的余数。

Calculates the remainder of a division.

- 1st Parameter: The original value.
- 2nd Parameter: The value to divide by.

EXAMPLE: `MOD(7,3)`		 // 1	
EXAMPLE:	`MOD(24,2)`	// 0		

#### ABS  求绝对值

Returns the positive version of number.

**1st Parameter**: The original value.

`ABS(3)`  //3

`ABS(-3)` //3

####  TO_CHAR 数字转 String

Converts a number into a formatted string (varchar) value using a formating mask pattern.

>  使用格式化掩码模式将数字转换为格式化的字符串（varchar）值。

- 1st Parameter: The original value.
- 2nd Parameter: The formatting mask pattern.

`TO_CHAR(3412.3138,'$9,999.99')` //$3412.31

| Format Mask Pattern | Description                                                  | Example           |
| ------------------- | ------------------------------------------------------------ | ----------------- |
| **9**               | **Digit placeholder. Ensures  output takes at least this much space. If there is no matching digit in the  converted number a** **space** **is used** | **9999**          |
| **0**               | **Digit placeholder. Ensures  output takes at least this much space. If there is no matching digit in the  converted number a** **zero** **is used** | **99****0****.9** |
| **$**               | **Adds a floating dollar sign to  the number (always appears immediately to the left of the last number)** | **$999**          |
| **.**               | **Specifies how many decimal  positions to display**         | **99.9**          |
| **,**               | **Thousands separator**                                      | **9,999**         |
| **L**               | **Formats dollar amounts using  ‘local’ currency setting (used instead of ‘$’)** | **L999**          |

![image-20221124001103795](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124001103795.png)

![image-20221124001205517](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124001205517.png)

![image-20221124001250252](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124001250252.png)

## 三. Date Functions

Date manipulation and formatting.

#### 1.**TO_CHAR** 日期格式

Converts a date value into a formatted string (varchar2) value using a formatting mask pattern.

- 1st Parameter: The original value.
- 2nd Parameter: The formatting mask pattern.

EXAMPLE: hire_date contains: '2021-01-15'

`TO_CHAR(hire_date,'Month DD, YYYY' )` //Returns January 15, 2021

表达格式

| **Element**      | **Description**                       | **Example**                                                 |
| ---------------- | ------------------------------------- | ----------------------------------------------------------- |
| **Month**        | **Name of month spelled out**         | **September**                                               |
| **Mon**          | **3 letter month abbreviation**       | **Sep**                                                     |
| **MM**           | **Two digit month value**             | **09**                                                      |
| **DD**           | **Day of month**                      | **Between 1 and [ 28, 29, 30, 31  ]**                       |
| **DDD**          | **Day of the year**                   | **1 = Jan 1; 365 = Dec 31**   **366 = Dec 31 of leap year** |
| **DAY**          | **Day of the week**                   | **Saturday**                                                |
| **YYYY**         | **4 digit year**                      | **2020**                                                    |
| **Y, YY, YYY**   | **1, 2 or 3 values in year**          | **2020, Y = 0**  **2020, YY = 20**  **2020, YYY = 020**     |
| **B.C. or A.D.** | **‘Before Christ’ or ‘anno  Domini’** | **531 B.C.**  **2020 A.D.**                                 |



| **SS**                 | **Seconds**                                                  | **Value 0-59**                                      |
| ---------------------- | ------------------------------------------------------------ | --------------------------------------------------- |
| **SSSS**               | **Seconds past midnight**                                    | **Value 0-86399**                                   |
| **MI**                 | **Minute**                                                   | **Value 0-59**                                      |
| **HH or HH12**         | **Hours**                                                    | **Value 1-12**                                      |
| **AM/A.M. or PM/P.M.** | **Indicates morning, afternoon  evening**  **Should be used with HH or HH12** | **AM/A.M. (before noon)**  **PM/P.M. (after Noon)** |
| **HH24**               | **Hours (****24 hour** **clock)**                            | **Value 0-23**                                      |

**Date Formating Example**

```sql
TO_CHAR(hire_date, 'Day Month DD YYYY') //Tuesday June 17 2003
TO_CHAR(hire_date, 'DD-Mon-YYYY') //17-Jun-2003
```

**Practice**
Select the start date and time for job id AC_MGR

```sql
SELECT TO_CHAR(start_date,'YYYY-MM-DD-HH:MI:SS') AS "Time Started" 
FROM job_history
WHERE job_id = 'AC_MGR';
```

Returns: 2001-10-28-12:00:00



#### 2.TO_DATE

Converts various date formats from a character representation **TO**  the internal format

This conversion must be done when:

- Performing any date math with a date constant

  > 用一个日期常数进行任何日期数学运算

- Attempting to use a date format your client does not understand

  > 试图使用你的客户不理解的日期格式
  >
  > Our machines accept ‘YYYY-MM-DD’ only 

The function has two parameters

1. The date to convert to internal format
2. A mask that identifies what the date string looks like
   - What the year, month, and day values are

EXAMPLE:

- add a new job history that started on June 27th, 2021 at 19:14:06 (24 hour clock)

```sql
INSERT INTO job_history 
 (employee_id,start_date,end_date,department_id,job_id)
VALUES(000,TO_DATE('2021-06-27-19:14:06','YYYY-MM-DD-HH24-MI-SS'),
       2021-09-27,11,'fake_id');
```



#### 3.COALESCE 

Substitutes a value for a NULL value returned by a query

> 用一个值代替一个查询返回的NULL值

实际用例：![image-20221124112411562](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124112411562.png)



```sql
SELECT department_name, COALESCE(TO_CHAR(manager_id, '9999'),'Manager not assigned') AS Manager
FROM departments
WHERE department_id IN (110,120,130);
```

**Note:** Column ‘manager_id’ is numeric, so it must be converted to **CHAR** for this query to work

![image-20221124112509808](/Users/liyifan/Library/Application Support/typora-user-images/image-20221124112509808.png)



### Functions within Functions 

Remember that you can put a function anywhere you can put a column name or a value. 

This flexibility is extremely useful for solving complex problems.



**Example:** Return only the **2nd word** and subsequent words in field that has multiple words.

How can we solve this problem? Where do we start?

在有多个单词的字段中，只返回第2个单词和后续单词。



**Example:**

**First, we need to find out if the field has more than one word. How can we find that?**

**We need to know the character position after the first space character!**

Do we have a function that can find a character position within a value? What if that position is not found? What result do we get?

**Answer:POSITION**

Example:  Find out if a Answer: POSITION string has more than one word

`Position(‘ ‘ IN 'Red River College', )`

The above SQL says: Starting at position 1, look for the **1st** instance of a space character!

This will return: **4**



**If we add 1 to this value, we have the starting character of the second word!**

Example:
Next, we will Select the second and subsequent words. Do we have a function that can return a partial string from within another string?

Answer:  SUBSTR()

**Example: Return the 2nd word of three words**
`SELECT SUBSTR('Red River College', 5)` Starting at position 5, return 5 characters.

This will return: River College.

Now we replace the hard-coded literal values (5) with our Position functions to find the space
`SELECT SUBSTR('Red River College’, POSITION(' ' IN 'Red River College’));`



TRY IT! -

Show addresses of all locations. Display the 2nd subsequent words in their own column together (Display the full address for reference as well)

```sql
SELECT SUBSTR(street_address, POSITION(' ' IN street_address) +1), street_address
FROM Locations;
```

## Summary

**What is a function?**

PostgreSQL functions are stored procedures and can be easily understood as a set of SQL and procedural statements. 
They are stored on the database server. 
A function can be invoked using the SQL interface. It facilitates to ease the operations within the database. 

Describe Character functions from this module.

Describe Number functions from this module.

Explain what symbol is used to do string concatenation in SQL?



快速查找常用 fuctions

https://www.techonthenet.com/postgresql/functions/index.php 

