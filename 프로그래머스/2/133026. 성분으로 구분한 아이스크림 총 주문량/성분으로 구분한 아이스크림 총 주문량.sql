-- 코드를 입력하세요
# 상반기 동안 성분 타입, GROUP BY 성분타입 총 주문량
#  총 주문량 작은 순서대로
#  총 주문량 as TOTAL_ORDER
SELECT ii.ingredient_type, sum(fh.total_order) as total_order
FROM first_half fh JOIN icecream_info ii on fh.flavor = ii.flavor
group by ii.ingredient_type
order by total_order 