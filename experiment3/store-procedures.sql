-- a. Procedure to insert one record
DELIMITER //
CREATE PROCEDURE InsertEmployee(IN emp_id INT, IN emp_name VARCHAR(50), IN emp_salary DOUBLE)
BEGIN
    INSERT INTO Employee(EmpID, Name, Salary) VALUES (emp_id, emp_name, emp_salary);
END //
DELIMITER ;

-- b. Procedure to retrieve salary
DELIMITER //
CREATE PROCEDURE GetSalary(IN emp_id INT, OUT emp_salary DOUBLE)
BEGIN
    SELECT Salary INTO emp_salary FROM Employee WHERE EmpID = emp_id;
END //
DELIMITER ;
