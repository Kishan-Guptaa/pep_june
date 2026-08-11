# Write your MySQL query statement below
SELECT max(num) as num from MyNumbers where num in (Select num from MyNumbers group by num having count(*) = 1)

