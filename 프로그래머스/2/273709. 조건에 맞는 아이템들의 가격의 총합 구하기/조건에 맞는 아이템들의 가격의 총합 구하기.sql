-- 코드를 작성해주세요
# RARITY LEGEND 인 경우
SELECT sum(price) as TOTAL_PRICE
FROM item_info
where rarity = 'legend'
