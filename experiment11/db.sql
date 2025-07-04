CREATE DATABASE college;

USE college;

CREATE TABLE students (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  branch VARCHAR(50)
);

INSERT INTO students VALUES (1, 'Madhu', 'CSE');
INSERT INTO students VALUES (2, 'Sravani', 'ECE');
INSERT INTO students VALUES (3, 'Raj', 'MECH');
