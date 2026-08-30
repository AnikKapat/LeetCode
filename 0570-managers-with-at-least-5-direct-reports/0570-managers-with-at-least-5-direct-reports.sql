# Write your MySQL query statement below
SELECT name from Employee
WHERE id IN (SELECT ManagerId FROM Employee GROUP BY ManagerId HAVING (COUNT(DISTINCT ID)) >= 5)