package com.itbank.member;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {

	@Select("select * from member")
	List<MemberDTO> selectMemberList();

	@Select("select * from member where userid = #{userid} and userpw = #{userpw}")
	MemberDTO selectMember(MemberDTO dto);

	
}
