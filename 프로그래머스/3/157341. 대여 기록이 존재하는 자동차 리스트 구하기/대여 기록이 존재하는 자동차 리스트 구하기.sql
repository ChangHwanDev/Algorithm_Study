-- 코드를 입력하세요
# 세단이고 10월에 대여 시작
# 자동차 ID는 중복이 없어야하고
# ORDER BY CAR_ID DESC
SELECT ccc.car_id
FROM CAR_RENTAL_COMPANY_CAR  ccc JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ccrh on ccc.car_id = ccrh.car_id
WHERE ccc.car_type = '세단' and ccrh.start_date like '%-10-%'
group by CAR_ID
order by CAR_ID DESC