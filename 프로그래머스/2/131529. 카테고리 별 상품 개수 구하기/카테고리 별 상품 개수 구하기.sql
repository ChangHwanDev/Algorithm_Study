-- 코드를 입력하세요
# product_code 앞 2자리 별 상품 개수 출력
SELECT SUBSTRING(product_code,1,2) as category , count(product_code)
FROM product
group by category 
order by category