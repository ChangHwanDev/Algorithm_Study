-- 코드를 입력하세요
#  ANIMAL_INS 에서 SEX_UPON_INTAKE Spayed, Neutered 아닌 경우
#  ANIMAL_OUT 에서 SEX_UPON_OUTCOME Spayed 이거나 Neutered 인 경우
SELECT ao.animal_id,ao.animal_type,ao.name
FROM animal_ins ai join animal_outs ao on ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake like 'Intact%' and (ao.sex_upon_outcome like'Spayed%' or ao.sex_upon_outcome like'Neutered%')
ORDER BY ao.animal_id