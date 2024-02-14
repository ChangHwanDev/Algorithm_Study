-- 코드를 입력하세요
# 총금액 70만원 이상, USER_ID, NICKNAME, SUM(PRICE)
# ORDER BY PRICE 
SELECT  ugu.USER_ID, ugu.NICKNAME, sum(ugb.PRICE) as total_sales
FROM used_goods_board ugb JOIN used_goods_user ugu on ugb.writer_id = ugu.user_id
where ugb.status = 'DONE'
group by ugu.USER_ID, ugu.NICKNAME
having total_sales >= 700000
order by total_sales