-- 코드를 입력하세요
# (통풍,열선,가죽) 옵션 포함 
# 자동차 수는 CARS로 지정
#  종류 기준 오름차순
SELECT car_type, count(1) as cars
FROM car_rental_company_car
where 
OPTIONS like '%가죽시트%' or
OPTIONS like '%통풍시트%' or
OPTIONS like '%열선시트%'
group by car_type
order by car_type 