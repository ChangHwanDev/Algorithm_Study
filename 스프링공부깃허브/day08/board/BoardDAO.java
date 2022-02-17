package com.itbank.board;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository 	// 데이터 저장소에 접근하는 객체
				// DAO : Data Access Object
				// 현재 클래스 내부에서 발생하는 예외를 모두 DataAccessException으로 바꿔준다
public interface BoardDAO {

	@Select("select * from board order by idx desc")
	List<BoardDTO> selectBoardList();

	@Select("select * from board where idx = #{idx}")
	BoardDTO selectBoard(int idx);

	@Insert("insert into board (title, writer, content) "
			+ "values (#{title}, #{writer}, #{content})")
	int insertBoard(BoardDTO dto);
	// #{}는 값의 자료형에 따라서 sql 구문상의 표현을 자료형에 맞게 바꿔준다
	// 문자열이면 ''로 묶어준다

	@Delete("delete board where idx = #{idx}")
	int deleteBoard(int idx);

	@Update("update board "
			+ "set 	title = #{title}, "
			+ "		writer = #{writer}, "
			+ "		content = #{content} "
			+ "where "
			+ "		idx = #{idx}")
	int updateBoard(BoardDTO dto);

}
