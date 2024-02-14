-- 코드를 입력하세요
#  게시물 3건 이상 등록
# USER_ID, NICKNAME, CITY STREET_ADDRESS1 STREET_ADDRESS2, TLNO
SELECT ugs.USER_ID, ugs.NICKNAME, concat(ugs.CITY,' ',ugs.STREET_ADDRESS1,' ',ugs.STREET_ADDRESS2) as 전체주소, concat(substr(ugs.TLNO,1,3),'-',substr(ugs.TLNO,4,4),'-',substr(ugs.TLNO,8,4)) as 전화번호
from used_goods_user ugs JOIN used_goods_board ugb on ugb.writer_id = ugs.user_id
group by ugs.user_id 
having count(ugs.user_id) > 2
order by ugs.user_id desc