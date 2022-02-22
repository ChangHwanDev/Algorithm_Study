package com.itbank.member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
public interface MemberDAO {

	@Select("select * from member")
	List<MemberDTO> selectMemberList();

	@Select("select * from member where userid = #{userid} and userpw = #{userpw}")
	MemberDTO selectMember(MemberDTO dto);

	@Insert("insert into member (userid, userpw, username,email,birth,gender) "
			+ "values (#{userid}, #{userpw}, #{username}, #{email}, #{birth}, #{gender})")
	int insertMember(MemberDTO dto);

	
	
}
