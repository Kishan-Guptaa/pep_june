# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as salary from Department d join Employee e on d.id = e.departmentId where e.salary = (
    select max(salary) from Employee where departmentId = e.departmentId
)