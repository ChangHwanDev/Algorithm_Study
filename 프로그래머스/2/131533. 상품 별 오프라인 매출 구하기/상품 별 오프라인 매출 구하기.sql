-- 코드를 입력하세요
# 상품코드 별 매출액(판매가 * 판매량)
#  order by 매출액 desc, 상품코드
SELECT d.product_code, sum(os.sales_amount * d.price) sales 
FROM product d JOIN offline_sale os on d.product_id = os.product_id
group by d.product_code
order by sales desc, d.product_code