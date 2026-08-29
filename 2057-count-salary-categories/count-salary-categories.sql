# Write your MySQL query statement below
select category,
    COUNT(account_id) AS accounts_count
    from (
        select 'Low Salary' as category Union all 
        select 'Average Salary' as category Union all
        select 'High Salary' as category 
    ) as categories
    LEFT JOIN Accounts
    ON (
        (category = 'Low Salary' AND income < 20000) OR
        (category = 'Average Salary' AND income BETWEEN 20000 AND 50000) OR
        (category = 'High Salary' AND income > 50000)
    )
    GROUP BY category;