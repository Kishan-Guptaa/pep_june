# Write your MySQL query statement below
select c.customer_id from Customer c join Product p on c.product_key = p.product_key group by c.customer_id HAVING COUNT(DISTINCT c.product_key) = (SELECT COUNT(*) FROM Product)
