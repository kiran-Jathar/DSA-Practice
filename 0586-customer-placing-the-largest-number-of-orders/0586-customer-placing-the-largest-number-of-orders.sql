# Write your MySQL query statement below
select customer_number 
from orders
GROUP BY customer_number
ORDER BY count(*) DESc 
LIMIT 1;