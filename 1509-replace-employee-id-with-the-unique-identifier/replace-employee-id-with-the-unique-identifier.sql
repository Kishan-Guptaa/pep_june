# Write your MySQL query statement below
Select eui.unique_id, e.name from Employees e left Join EmployeeUNI eui on e.id = eui.id