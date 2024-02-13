-- 코드를 입력하세요
# 생일이 3월
# 전화번호가 NULL이 아닌 경우
#  order by member_id
SELECT member_id, member_name,gender,DATE_FORMAT(date_of_birth,'%Y-%m-%d') as date_of_birth
FROM member_profile
where gender ='W' and  tlno is not null and DATE_FORMAT(date_of_birth,'%Y-%m-%d') like '%-03-%'
order by member_id