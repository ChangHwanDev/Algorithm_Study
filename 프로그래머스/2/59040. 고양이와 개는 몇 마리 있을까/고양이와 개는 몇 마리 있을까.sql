-- 코드를 입력하세요
# 고양이 개 각각 몇 마리인지
SELECT animal_type, count(animal_id) as count
FROM animal_ins
group by animal_type
order by animal_type