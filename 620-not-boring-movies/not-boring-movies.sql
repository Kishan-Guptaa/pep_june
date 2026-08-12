# Write your MySQL query statement below
SELECT id, movie, description, rating from Cinema where MOD(id, 2) != 0 and description != 'boring' Order by rating desc;