-- 코드를 입력하세요
# 10월 16일에 대여중인 경우 대여중이라 표시하고 아닐 경우 대여 가능 AS AVAILABILITY
# 반납 날짜가 16일 이여도 대여중
# ORDER BY CAR_ID DESC
SELECT CAR_ID, MAX(   CASE WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN '대여중' 
                     ELSE '대여 가능' END) AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
ORDER BY CAR_ID DESC