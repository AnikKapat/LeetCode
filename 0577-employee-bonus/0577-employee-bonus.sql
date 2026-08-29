-- # Write your MySQL query statement below
-- SELECT name FROM Employee INNER JOIN bonus FROM Bonus ON Employee.empID = Bonus.empID
-- WHERE Bonus.bonus < 1000 OR Bonus.bonus IS NULL

SELECT e.name, b.bonus FROM Employee e LEFT JOIN Bonus b ON e.empID = b.empID
WHERE b.bonus < 1000 OR b.bonus IS NULL;