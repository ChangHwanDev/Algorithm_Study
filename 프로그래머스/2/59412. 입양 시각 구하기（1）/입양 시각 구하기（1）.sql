-- 코드를 입력하세요
# 09:00 ~ 19:59까지 
# group by 시간
#  order by 시간 순
SELECT DATE_FORMAT(datetime,'%H') as hour, count(animal_id) as count
from animal_outs
where DATE_FORMAT(datetime,'%H') between 9 and 19
group by hour
order by hour