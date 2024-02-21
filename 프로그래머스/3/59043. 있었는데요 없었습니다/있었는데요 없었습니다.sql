-- 코드를 입력하세요
# SELECT ANIMAL_ID,NAME
# WHERE 보호 시작일보다 입양일이 더 빠른 동물
# ORDER BY 보호 시작일
# AI.dateime 보호 시작일 AO.datetime 입양일
SELECT ai.animal_id, ai.name
FROM ANIMAL_INS ai JOIN ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
WHERE ai.datetime > ao.datetime 
order by ai.datetime