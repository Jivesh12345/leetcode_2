/* Write your T-SQL query statement below */
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Department d
         LEFT JOIN (
    SELECT
        emp.departmentId,
        emp.name,
        emp.salary,
        DENSE_RANK() OVER (
            PARTITION BY emp.departmentId
            ORDER BY emp.salary DESC
            ) AS dr
    FROM Employee emp
) e ON e.departmentId = d.id
WHERE e.dr <= 3;