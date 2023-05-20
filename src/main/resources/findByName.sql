SELECT product_name
FROM netology.orders
WHERE customer_id in
      (SELECT id
       FROM netology.customers
       WHERE LOWER(name) = :username);