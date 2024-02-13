-- 코드를 입력하세요
# 경제 카테고리
#  출판일 기준 오름차순
SELECT b.book_id, a.author_name, DATE_FORMAT(b.published_date,'%Y-%m-%d') as published_date
FROM BOOK b JOIN AUTHOR a on b.author_id = a.author_id
where b.category ='경제' 
order by b.published_date 