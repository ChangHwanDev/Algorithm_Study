-- 코드를 입력하세요
# 입양을 못 간 동물 이름, 보호 시작일
# 보호 시작일 순으로 조회 ASC
# limit 3
SELECT ai.name, ai.datetime
from animal_ins ai left outer JOIN animal_outs ao on ai.animal_id = ao.animal_id
where ao.animal_id is null
order by ai.datetime
limit 3