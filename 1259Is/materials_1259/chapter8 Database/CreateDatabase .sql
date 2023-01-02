DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Salesreps;
DROP TABLE IF EXISTS Offices;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Products;

CREATE TABLE IF NOT EXISTS Customers
(CustNum     INT(10)      NOT NULL,
 Company     VARCHAR(20)  NOT NULL,
 CustRep     INT(10),
 CreditLimit INT(6),
 CONSTRAINT CustomersPK 
 	PRIMARY KEY (CustNum)
);


CREATE TABLE IF NOT EXISTS Salesreps
(SalesRep    INT(10)      NOT NULL,
 Name        VARCHAR(15)  NOT NULL,
 Age         INT(3),
 RepOffice   INT(10),
 Title       VARCHAR(15),
 HireDate    DATE,
 Manager     INT(10),
 Quota       INT(10),
 Sales       DOUBLE(12,2) NOT NULL,
 CONSTRAINT SalesrepsPK 
 	PRIMARY KEY (Salesrep)
);

CREATE TABLE IF NOT EXISTS Offices
(Office      INT(10)      NOT NULL,
 CIty        VARCHAR(15)  NOT NULL,
 Region      VARCHAR(10)  NOT NULL,
 Mgr         INT(10),
 Target      INT(10),
 Sales       DOUBLE(12,2) NOT NULL,
 CONSTRAINT OfficesPK 
 	PRIMARY KEY (Office)
);

CREATE TABLE IF NOT EXISTS Orders
(OrderNum    INT(10)      NOT NULL,
 OrderDate   DATE,
 Cust        INT(10),
 Rep         INT(10),
 Mfr         CHAR(3)      NOT NULL,
 Product     CHAR(5)      NOT NULL,
 Qty         INT(5)       NOT NULL,
 Amount      DOUBLE(9,2)  NOT NULL,
 CONSTRAINT OrdersPK 
 	PRIMARY KEY (OrderNum)
);

CREATE TABLE IF NOT EXISTS Products
(Mfr         CHAR(3)      NOT NULL,
 Product     CHAR(5)      NOT NULL,
 Description VARCHAR(20)  NOT NULL,
 Price       DOUBLE(9,2)  NOT NULL,
 QtyOnHand   INT(5),
 CONSTRAINT ProductsPK 
	PRIMARY KEY (Mfr, Product)
);

COMMIT;

INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2111, 'JCP Inc'            ,103, 500.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2102, 'First Corp'         ,101, 650.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2103, 'Acme Mfg.'          ,105, 500.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2123, 'Carter and Sons'      ,102, 400.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2107, 'Ace International'  ,110, 350.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2115, 'Smithson Corp.'     ,101, 200.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2101, 'Jones Mfg.'         ,106, 650.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2112, 'ZetaCorp'           ,108, 500.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2121, 'QMA Assoc.'         ,103, 450.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2114, 'Orion Corp'         ,102, 200.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2124, 'Peter Brothers'     ,107, 400.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2108, 'Holm and Landis'      ,109, 550.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2117, 'J.P. Sinclair'      ,106, 350.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2122, 'Three-Way Lines'   ,105, 300.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2120, 'Rico Enterproses'   ,102, 500.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2106, 'Fred Lewis Corp'    ,102, 650.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2119, 'Solomon Inc.'       ,109, 250.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2118, 'Midwest Systems'    ,108, 600.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2113, 'Ian and Schmidt'      ,104, 200.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2109, 'Chen Associates'    ,103, 250.00 );
INSERT INTO Customers  (CustNum, Company, CustRep, CreditLimit)
VALUES (2105, 'AAA Investments'    ,101, 450.00 );


INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (105, 'Bill Adams'     , 37, 13, 'Sales Rep' , '1988-02-12', 104, 3500.00, 3679.11 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (037, 'Jim Anderson'     , NULL, NULL, NULL , '1988-02-12', NULL, NULL, 0 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (109, 'Mary Jones'     , 31, 11, 'Sales Rep' , '1989-10-12', 106, 3000.00, 3927.25 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (102, 'Sue Smith'      , 48, 21, 'Sales Rep' , '1986-12-10', 108, 3500.00, 4740.50 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (106, 'Sam Clark'      , 52, 11, 'VP Sales'  , '1988-06-14', NULL, 2750.00, 2999.12 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (104, 'Bob Smith'      , 33, 12, 'Sales Mgr' , '1987-05-19', 106, 2000.00, 1425.94 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (101, 'Dan Roberts'    , 45, 12, 'Sales Rep' , '1986-10-20', 104, 3000.00, 3057.63 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (110, 'Tom Snyder'     , 41, NULL  , 'Sales Rep' , '1990-01-13', 101,  NULL     ,  759.85 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (108, 'Larry Finch'    , 62, 21, 'Sales Mgr' , '1989-10-12', 106, 3500.00, 3618.65 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (103, 'Paul Cruz'      , 29, 12, 'Sales Rep' , '1987-03-01', 104, 2750.00, 2867.75 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (107, 'Nancy Angelli'  , 49, 22, 'Sales Rep' , '1988-11-14', 108, 3000.00, 1860.42 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (013, 'Liz Yeo-Clark'  , 64, 30, 'Senior Rep' , '1953-01-14', 106, 4500.00, 2265.55 );
INSERT INTO Salesreps (SalesRep, Name, Age, RepOffice, Title, HireDate, Manager, Quota, Sales)
VALUES (115, 'I.B. Clarkson'  , 21, 22, 'Sales Rep' , '1980-03-25', 108, 1500.00, 235.44 );

INSERT INTO Offices (Office, City, Region, Mgr, Target, Sales)
VALUES (22, 'Denver'       , 'Western'  , 108, 3000.00, 1860.42 );
INSERT INTO Offices (Office, City, Region, Mgr, Target, Sales)
VALUES (11, 'New York'     , 'Eastern'  , 106, 5750.00, 6926.37 );
INSERT INTO Offices (Office, City, Region, Mgr, Target, Sales)
VALUES (12, 'Chicago'      , 'Eastern'  , 104, 8000.00, 7350.42 );
INSERT INTO Offices (Office, City, Region, Mgr, Target, Sales)
VALUES (13, 'Atlanta'      , 'Eastern'  , 105, 3500.00, 3679.11 );
INSERT INTO Offices (Office, City, Region, Mgr, Target, Sales)
VALUES (21, 'Los Angeles'  , 'Western'  , 108, 7250.00, 8359.15 );
INSERT INTO Offices (Office, City, Region, Mgr, Target, Sales)
VALUES (30, 'Dallas'       , 'Southern' , 107, 9500.00,   10.00 );


INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112961, '2000-04-20', 2117, 106, 'REI', '2A44L', 07, 315.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113012, '2000-02-28', 2111, 105, 'ACI', '41003', 35,  37.45 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112989, '1990-01-03', 2101, 106, 'FEA', 'L14'  , 06,  14.58 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113051, '1990-02-10', 2118, 108, 'QSA', 'XK47' , 04,  14.20 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112968, '2000-02-29', 2102, 101, 'ACI', '41004', 34,  39.78 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113036, '1990-01-30', 2107, 110, 'ACI', '4100Z', 09, 225.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113045, '1990-02-02', 2112, 108, 'REI', '2A44R', 10, 450.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112963, '1989-12-17', 2103, 105, 'ACI', '41004', 28,  32.76 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113013, '1990-01-14', 2118, 108, 'BIC', '41003', 01,   6.52 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113058, '1990-02-23', 2108, 109, 'FEA', 'L12'  , 10,  14.80 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112997, '1990-01-08', 2124, 107, 'BIC', '41003', 01,   6.52 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112983, '1989-12-27', 2103, 105, 'ACI', '41004', 06,   7.02 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113024, '1990-01-20', 2114, 108, 'QSA', 'XK47' , 20,  71.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113062, '1990-02-24', 2124, 107, 'FEA', 'L14'  , 10,  24.30 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112979, '1999-02-28', 2114, 102, 'ACI', '4100Z', 06, 150.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113027, '1990-01-22', 2103, 105, 'ACI', '41002', 54,  41.04 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113007, '1990-01-08', 2112, 108, 'IMM', '773C' , 03,  29.25 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113069, '1990-03-02', 2109, 107, 'IMM', '775C' , 22, 313.50 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113034, '1990-01-29', 2107, 110, 'REI', '2A45C', 08,   6.32 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112992, '1989-11-04', 2118, 108, 'ACI', '41002', 10,   7.60 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112975, '1989-10-12', 2111, 103, 'REI', '2A44G', 06,  21.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113055, '1990-02-15', 2108, 101, 'ACI', '4100X', 06,   1.50 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113048, '1990-02-10', 2120, 102, 'IMM', '779C' , 02,  37.50 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112993, '1989-01-04', 2106, 102, 'REI', '2A45C', 24,  18.96 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113065, '1990-02-27', 2106, 102, 'QSA', 'XK47' , 06,  21.30 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113003, '1990-01-25', 2108, 109, 'IMM', '779C' , 03,  56.25 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113049, '1990-02-10', 2118, 108, 'QSA', 'XK47' , 02,   7.76 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (112987, '1989-12-31', 2103, 105, 'ACI', '4100Y', 11, 275.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113057, '1990-02-18', 2111, 103, 'ACI', '4100X', 24,   6.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113042, '1990-02-02', 2113, 101, 'REI', '2A44R', 05, 225.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113090, '2004-01-23', 2999, 101, 'ACI', '41001', 10,   5.50 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113091, '2004-01-23', NULL, 101, 'IMM', '887p' ,100, 250.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113192, '2004-01-23', 2108, 109, 'BIC', '4103' ,300,  15.00 );
INSERT INTO Orders (OrderNum, OrderDate, Cust, Rep, Mfr, Product, Qty, Amount)
VALUES (113195, '2004-01-23', 2102, 101, 'BIC', '4103' ,500,  25.00 );

INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('REI', '2A45C', 'Ratchet Link'       ,   .79, 210 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '4100Y', 'Widget Remover'     , 27.50,  25 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('QSA', 'XK47' , 'Reducer'            ,  3.55,  38 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('BIC', '41672', 'Plate'              ,  1.80,   0 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('IMM', '779C' , '900-lb Brace'       , 18.75,   9 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '41003', 'Size 3 widget'      ,  1.07, 207 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '41004', 'Size3 4 widget'     ,  1.17, 139 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('BIC', '41003', 'Handle'             ,  6.52,   3 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('IMM', '887P' , 'Brace Pin'          ,  2.50,  24 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('QSA', 'XK48' , 'Reducer'            ,  1.34, 203 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('REI', '2A44L', 'Left Hinge'         , 45.00,  12 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('FEA', 'L12'  , 'Housing'            ,  1.48, 115 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('IMM', '887H' , 'Brace Holder'       ,   .54, 223 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('BIC', '41089', 'Retainer'           ,  2.25,  78 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '41001', 'Size 1 widget'      ,   .55, 277 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('IMM', '775C' , '500 lb Brace'       , 14.25,   5 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '4100Z', 'Widget Installer'   , 25.00,  28 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('QSA', 'XK48A', 'Reducer'            ,  1.77,  37 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '41002', 'Size 2 Widget'      ,   .76, 167 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('REI', '2A44R', 'Right Hinge'        , 45.00,  12 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('IMM', '773C' , '300 lb Brace'       ,  9.75,  28 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('ACI', '4100X', 'Widget Adjuster'    ,   .25,  37 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('FEA', 'L14'  , 'Motor Mount'        ,  2.43,  15 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('IMM', '887X' , 'Brace Retainer'     ,  4.75,  32 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('REI', '2A44G', 'Hinge Pin'          ,  3.50,  14 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('FEA', '4103', 'Bar Clip'            ,   .05, 326 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('FEA', 'XK48', 'Hose'                ,   .17,   2 );
INSERT INTO Products (Mfr, Product, Description, Price, QtyOnHand)
VALUES ('BIC', 'L14',  'Bowl'                ,  3.95,  17 );
 
COMMIT;