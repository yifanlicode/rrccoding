/*Run this script, then attempt to answer these questions.  Solutions at the end of this file.*/

-- PRACTICE questions

-- Question 1: Make a report on players, show their email address and alias
-- Question 2: We want to see all the equipment Darlok owns.  Display just the equipment names in his inventory
-- Question 3: Show all the Equipment worth more than 200 bottle caps that weighs less than 10l lbs. You only need to display the Name, weight and value.
-- Question 4: Display the name of the people who own a backpack.  Just display their alias.
-- Question 5: Display a full list of all Players and their inventory. Show us their alias and equipment name. Be sure to include players who do not have inventory as well! Order this result by alias and equipment name
-- Question 6: We want to see the name of the equipment where a player has more then 10 of them in their inventory. Only display the equipment name once in this list.
-- Question 7: Show us a list of all items which are not in anyone's equipment.
-- Question 8: Show us a list of all Items which are in someone's equipment (no duplicate names)
-- Question 9: Modify question 8 and remove any items which are in "Raven's" inventory. In other words, if any item is found in Raven's inventory, it should NOT appear in your final result, even if it is in other people's inventory.
-- Question 10: Name all the custom made equipment and the name of the person who made it (use their alias only)
-- Question 11: Using a Join, show all the custom made equipment in a player's inventory (also show the alias of the player who has the equipment).
-- Question 12: Modify the above statement to ONLY SHOW equipment if the player is *NOT* the same player who made the equipment.
-- Example: If Raven made the spell book, but it's found in someone else's inventory, we want to see that! But we don't need to see that Raven has their own item.




/* This is the information I used to make my tables:
Players have 0 or more equipment.
The same equipment can be owned by 0 or more players.
One piece of equipment can be custom made by a player (but do not have to be)
A Player can make 0 or more custom equipment
*/

DROP TABLE Inventory;
DROP TABLE Equipment;
DROP TABLE Player;

/*We did not cover SEQUENCEs in our lecture slides,
TLDR: they will create an auto increasing number for our primary keys!*/
DROP SEQUENCE player_sequence;
DROP SEQUENCE equipment_sequence;
DROP SEQUENCE inventory_sequence;

/*Player's Primary Key's start at 10 and go up automatically.. 10, 11, 12, 13, etd.. */
CREATE SEQUENCE player_sequence START WITH 10 INCREMENT BY 1;
CREATE SEQUENCE equipment_sequence START WITH 100 INCREMENT BY 1;
CREATE SEQUENCE inventory_sequence START WITH 1000 INCREMENT BY 1;

CREATE TABLE Player
(
    player_id       NUMBER(10)      NOT NULL,
    alias           VARCHAR(16)     NOT NULL,
    first_name      VARCHAR(50)             ,
    last_name       VARCHAR(50)             ,
    birthday        DATE                    ,
    email           VARCHAR(255)    NOT NULL,
    CONSTRAINT PlayerPK PRIMARY KEY (player_id)
);

CREATE TABLE Equipment
(
    equipment_id     NUMBER(10)      NOT NULL,
    name             VARCHAR(100)    NOT NULL,
    value            NUMBER(8,2)             , -- THIS IS BOTTLE CAPS
    weight           NUMBER(7,3)             ,
    created_by_player NUMBER(10)             , -- 0 to 1 relationship with Player
    CONSTRAINT EquipmentPK PRIMARY KEY (equipment_id),
    CONSTRAINT weight_must_be_above_0 CHECK (weight > 0),
    CONSTRAINT value_must_be_above_0 CHECK (value > 0),
    CONSTRAINT custom_created_by_playerFK
        FOREIGN KEY (created_by_player) REFERENCES Player
);

CREATE TABLE Inventory
(
    inventory_id         NUMBER(10)      NOT NULL,
    player_id            NUMBER(10)      NOT NULL, -- 1 to many with player
    equipment_id         NUMBER(10)      NOT NULL, -- 1 to many with equipment
    quality              NUMBER(3)       NOT NULL,
    CONSTRAINT InventoryPK PRIMARY KEY (inventory_id),
    CONSTRAINT InventoryPlayerFK
        FOREIGN KEY (player_id) REFERENCES Player,
    CONSTRAINT InventoryEquipmentFK
        FOREIGN KEY (equipment_id) REFERENCES Equipment
);


INSERT INTO Player (player_id,alias,email,first_name,last_name,birthday) 
    valueS (PLAYER_SEQUENCE.nextval,'Darlok','darlok@hotmail.com','Scott','Wachal','1990-08-15');
INSERT INTO Player (player_id,alias,email,first_name,last_name,birthday) 
    valueS (player_sequence.nextval,'Mystic','samr@yahoo.ca','Sam','Rucak','1999-03-19');
INSERT INTO Player (player_id,alias,email,first_name,last_name,birthday) 
    valueS (player_sequence.nextval,'Gambit','bsmith@gmail.com','Bart','Smith','2001-12-01');
INSERT INTO Player (player_id,alias,email,first_name,last_name,birthday) 
    valueS (player_sequence.nextval,'Raven','ravenclaw@hogwars.co.uk','Andrea','Heatherton','2000-10-25');
INSERT INTO Player (player_id,alias,email,first_name,last_name,birthday) 
    valueS (player_sequence.nextval,'1337_Hac|<er','fakenews@notreal.info',null,null,null);
    
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Rapier','250','1.5',null);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Backpack','180','3',null);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Rad-X','50','0.5',null);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Fruty Oaty Bar','25','0.05',null);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Alien Blaster Rifle','5000','20',null);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Darlok''s Custom Sniper Rifle','2750','17.5',11);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Raven''s Spell Book','8750','5',14);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Paper Clip','0.05','0.001',null);
INSERT INTO Equipment (equipment_id, name, value, weight,created_by_player) 
    valueS (equipment_sequence.nextval,'Tin can','0.01','0.02',null);


INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,11,101,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,11,102,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,11,104,10);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,11,106,1);

INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,12,107,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,12,105,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,12,103,999);


INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,13,102,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,13,104,5);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,13,108,25);

INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,14,102,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,14,107,1);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,14,104,2);
INSERT INTO Inventory (inventory_id,player_id,equipment_id,quality) 
    valueS (inventory_sequence.nextval,14,103,1);

SELECT * FROM Player;
SELECT * FROM Equipment;
SELECT * FROM Inventory;







-- SOLUTIONS (Don't look until you've tried them first for practice!)

-- Question 1: Make a report on players, show their email address and alias
SELECT p.email, p.alias
    FROM Player p;
    
-- Question 2: We want to see all the equipment Darlok owns.  Display just the equipment names in his inventory
SELECT e.name
    FROM Equipment e
    JOIN Inventory i ON e.equipment_id = i.equipment_id
    JOIN Player p ON p.player_id = i.player_id
    WHERE p.alias = 'Darlok';
-- Or if I assume I know the player_id I could avoid joining Player and use the player_id in Inventory

    
-- Question 3: Show all the Equipment worth more than 200 bottle caps that weighs less than 10l lbs. You only need to display the name, weight and value.
SELECT e.name, e.weight, e.value
    FROM Equipment e
    WHERE e.value > 200 AND e.weight < 10;

-- Question 4: Display the name of the people who own a backpack.  Just display their alias.
SELECT p.alias
    FROM Player p
    JOIN Inventory i ON p.player_id = i.player_id
    JOIN Equipment e ON e.equipment_id = i.equipment_id
    WHERE e.name = 'Backpack';
-- or if you know the ID of backpack you could avoid the join to Equipment.

-- Question 5: Display a full list of all Players and their inventory. Show us their alias and equipment name. 
-- Be sure to include players who do not have inventory as well! Order this result by alias and equipment name
SELECT  p.alias, 
        e.name AS "Equipment name"
    FROM Player p
    LEFT OUTER JOIN Inventory i ON p.player_id = i.player_id
    LEFT OUTER JOIN Equipment e ON e.equipment_id = i.equipment_id
    ORDER BY p.alias, e.name;

-- Question 6: We want to see the name of the equipment where a player has more then 10 of them in their inventory. Only display the equipment name once in this list.
SELECT DISTINCT e.name AS "Equipment Name"
    FROM Inventory i 
    JOIN Equipment e ON e.equipment_id = i.equipment_id
    WHERE i.quality > 10;

-- Question 7: Show us a list of all items which are not in anyone's equipment.
SELECT e.name AS "Equipment name"
    FROM Equipment e
    LEFT OUTER JOIN Inventory i ON e.equipment_id = i.equipment_id
    WHERE i.equipment_id IS NULL;

-- Question 8: Show us a list of all Items which are in someone's equipment (no duplicate names)
SELECT DISTINCT e.name AS "Equipment Name"
    FROM Inventory i 
    JOIN Equipment e ON e.equipment_id = i.equipment_id;

-- Question 9: Modify question 8 and remove any items which are in "Raven's" inventory. In other words, if any item is found in Raven's inventory, it should NOT appear in your final result, even if it is in other people's inventory.
SELECT DISTINCT e.name AS "Equipment Name"
    FROM Inventory i 
    JOIN Equipment e ON e.equipment_id = i.equipment_id
MINUS
    SELECT e2.name 
        FROM Equipment e2 
        JOIN Inventory i2 ON e2.equipment_id = i2.equipment_id
        JOIN Player p2 ON p2.player_id = i2.player_id
        WHERE p2.alias = 'Raven';

-- Question 10: name all the custom made equipment and the name of the person who made it (use their alias only)
    SELECT p.alias, e.name AS "Equipment Name" 
        FROM Equipment e 
        JOIN Player p ON p.player_id = e.created_by_player;

-- Question 11: Using a Join, show all the custom made equipment in a player's inventory (also show the alias of the player who has the equipment).
    SELECT e.name, p.alias
        FROM Equipment e 
        JOIN Inventory i ON e.equipment_id = i.equipment_id
        JOIN Player p ON p.player_id = i.player_id
        WHERE e.created_by_player IS NOT NULL;

-- Question 12: Modify the above statement to ONLY SHOW equipment if the player is *NOT* the same player who made the equipment.
-- Example: If Raven made the spell book, but it's found in someone else's inventory, we want to see that! But we don't need to see that Raven has their own item.
    SELECT e.name, p.alias
        FROM Equipment e 
        JOIN Inventory i ON e.equipment_id = i.equipment_id
        JOIN Player p ON p.player_id = i.player_id
        WHERE e.created_by_player IS NOT NULL
        AND p.player_id <> e.created_by_player;

--  This is out of scope right now, but just for fun:
-- Question 13: display the first and last name together in a single column, if there is no first name, display 'No name On Record' instead.
    SELECT NVL2(p.first_name, p.first_name || ' ' || p.last_name, 'No name On Record') AS "Full Name"
        FROM Player p;