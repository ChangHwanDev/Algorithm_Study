-- 코드를 입력하세요
#  2022년 5월에 예약한 환자 수 as 5월예약건수
#  GROUP BY 진료과 코드
#  ORDER BY 환자수 , 진료과 코드
SELECT mcdp_cd as 진료과코드, count(mcdp_cd) as 환자수
FROM  appointment
WHERE APNT_YMD like '2022-05%'
group by mcdp_cd
order by 환자수, mcdp_cd