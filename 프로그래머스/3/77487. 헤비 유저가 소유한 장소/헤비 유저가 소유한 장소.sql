-- 코드를 입력하세요
# 헤비 유저가 등록한 공간의 정보를
# 아이디 순으로 조회

SELECT id, name, host_id
FROM places
WHERE host_id IN (
    SELECT host_id
    FROM places
    GROUP BY host_id
    HAVING COUNT(*) > 1
)
ORDER BY id;