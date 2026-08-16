# Write your MySQL query statement below
SELECT user_id, email from Users where email REGEXP '^[A-Za-z0-9_]+@[a-z]+\\.com$' order by user_id asc
