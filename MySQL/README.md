# MySQL Journey

## Problem statement

The goal is to manage employees for an IT organization.

#### Database management

This was categorized using the following roles:

- **admin**: 
  - Has high-level access to the entire MySQL account, serving as an alternative to `root`.
  - Manages users.
- **developer**:
  - Has high-level access only to the `my_organization` database.
  - Manages tables.
- **analyst**:
  - Has read-only access to the `my_organization` database.
  - Accesses data.
- **app**:
  - Similar to `developer`, but this role is intended for applications like microservices, not physical users.

#### Tables

- **employees**: Contains information about employees.
  - `id`: Six-digit unique primary key with auto-increment.
  - `name`: Name of the employee.
  - `password`: Employee's password.
  - `role_id`: Foreign key linked to the `roles` table.

- **roles**: Contains information about employee roles.
  - `id`: Unique string identifier.
  - `name`: Name of the role.

- **address**: Contains the address of employees.
  - `id`: Shared primary key, which is the primary key of the `employees` table. Since the address is unique, it's better to have a shared primary key.
  - `area`: Area of the address.
  - `pin_code`: PIN code of the address.

## Start MySQL

```batch
mysql -h localhost -P 3306 -u root -p // Enter password in prompt
mysql -h localhost -P 3306 -u root -p"test123" // Password in command line
```

## Create role and assign grants

- In below example admin role created using ROOT account.
- SQL can be logged in as multiple user, the default user is ROOT.
- But Database administrator, should not use ROOT as credentials.
- Using ROOT credentials, create ADMIN role, create users and assign ADMIN role to them.
- With this admin role create further roles and users.

```sql
-- Create admin role and grant access to whole
CREATE ROLE 'admin'@'%';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%';
GRANT CREATE USER, CREATE ROLE, GRANT OPTION ON *.* TO 'admin'@'%'; -- Above grant is not enough for creating role and user
FLUSH PRIVILEGES;

-- Create other supporting roles and grant access to only my_organization database
CREATE ROLE 'developer';
GRANT ALL PRIVILEGES ON my_organization.* TO 'developer'@'%';
CREATE ROLE 'app';
GRANT ALL PRIVILEGES ON my_organization.* TO 'app'@'%';
CREATE ROLE 'analyst';
GRANT SELECT ON my_organization.* TO 'analyst'@'%';
FLUSH PRIVILEGES;
```

## Create user and assign roles

```sql
CREATE USER 'imViki23'@'%' IDENTIFIED BY 'imViki23123';
GRANT 'admin'@'%' TO 'imViki23'@'%';
SET DEFAULT ROLE 'admin'@'%' TO 'imViki23'@'%';
FLUSH PRIVILEGES;
```

## Create and Use database

```sql
CREATE DATABASE my_organization;
CREATE DATABASE my_no_access_organization; -- only admin have access, not developer, app and analyst

-- Switch between databases
USE my_organization;
```

## Create table

```sql
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    role_id VARCHAR(100) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
) AUTO_INCREMENT = 100000;
```

## Alter table

```sql
-- Add column with foreign key support
ALTER TABLE employees
ADD COLUMN role_id INT,
ADD FOREIGN KEY (role_id) REFERENCES roles(id);

-- Modify column, here not null is added
ALTER TABLE employees
MODIFY COLUMN role_id INT NOT NULL;

-- Drop foreign key constraint
ALTER TABLE employees DROP FOREIGN KEY employees_ibfk_1;

-- Drop column
ALTER TABLE employees DROP COLUMN role_id;
```

## Insert data

```sql
-- Simple data insertion
INSERT INTO roles (id, name) VALUES ('manager', 'Manager');

-- Shared primary key example insertion
INSERT INTO employees (first_name, last_name, role_id) VALUES ('Adam', 'Lee', 'hr');
SET @employee_id = LAST_INSERT_ID(); -- Shared primary key, so use employee table primary key in address table
INSERT INTO address (id, door_no, street, area, city, state, country, pin_code)
    VALUES (@employee_id, '1234', 'Rkm street', 'Playfield', 'Anytowm', 'Anystate', 'Anycountry', '123456');
```

## Utils

```sql
-- Truncate table disabling foreign key checks
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE employees;
SET FOREIGN_KEY_CHECKS = 1;
```
