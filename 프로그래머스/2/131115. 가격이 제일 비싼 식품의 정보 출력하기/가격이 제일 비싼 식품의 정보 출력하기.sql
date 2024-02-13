-- 코드를 입력하세요
# 제일 비싼 식품
SELECT product_id, product_name, product_cd, category, price
FROM food_product
order by price desc limit 1