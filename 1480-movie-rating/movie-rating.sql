# Write your MySQL query statement below
(select u.name as results from Users u join MovieRating m on u.user_id = m.user_id group by u.user_id, u.name order by count(*) desc, u.name limit 1)
union All
(
    SELECT m.title AS results
    FROM Movies m
    JOIN MovieRating mr
        ON m.movie_id = mr.movie_id
    WHERE mr.created_at >= '2020-02-01'
      AND mr.created_at < '2020-03-01'
    GROUP BY m.movie_id, m.title
    ORDER BY AVG(mr.rating) DESC, m.title
    LIMIT 1
);