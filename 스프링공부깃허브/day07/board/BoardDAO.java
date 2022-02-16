package com.it.board;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository // 데이터 저장소에 접근하는 객체
			// DAO : Data Access Object
			// 현재 클래스 내부에서 발생하는 예외를 모두 DataAccessException으로 바꿔준다
public interface BoardDAO {

	@Select("select * from board order by idx desc")
	List<BoardDTO> selectBoardList();


	@Select("select * from board where idx = #{idx}")
	BoardDTO selectBoard(int idx);
}
