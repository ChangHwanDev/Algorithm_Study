-- 코드를 입력하세요
# 조회수가 가장 높은 게시물에 대한 첨부파일 경로
# ORDER BY FILE_ID DESC
# 기본적인 파일 경로 /home/grep/src/ + 게시글 ID + / FILEID+ FILENM + FILE_EXT
SELECT concat('/home/grep/src/', ugf.board_id , '/',ugf.FILE_ID , ugf.FILE_NAME , ugf.FILE_EXT) as FILE_PATH
FROM used_goods_file ugf JOIN used_goods_board ugb on ugb.board_id = ugf.board_id
where ugb.views = (select max(views) from used_goods_board)
ORDER BY  ugf.file_id desc