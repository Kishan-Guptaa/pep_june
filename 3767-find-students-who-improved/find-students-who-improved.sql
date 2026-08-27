# Write your MySQL query statement below
select s1.student_id, s1.subject, s1.score as first_score, s2.score as latest_score from Scores s1 join Scores s2 on s1.student_id = s2.student_id and s1.subject = s2.subject where s1.exam_date = (
    select min(exam_date) from Scores where student_id = s1.student_id and subject = s1.subject
)AND s2.exam_date = (
    SELECT MAX(exam_date)
    FROM Scores
    WHERE student_id = s2.student_id
    AND subject = s2.subject
)
and s2.score > s1.score
ORDER BY s1.student_id, s1.subject;