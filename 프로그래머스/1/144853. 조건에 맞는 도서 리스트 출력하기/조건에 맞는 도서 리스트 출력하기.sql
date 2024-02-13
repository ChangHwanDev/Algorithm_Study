-- 코드를 입력하세요
SELECT book_id,DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as published_date
FROM book
WHERE category = '인문' and published_date between '2021-01-01' and '2021-12-31' order by published_date desc