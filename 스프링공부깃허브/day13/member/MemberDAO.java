package com.itbank.member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

	@Select("Select userid from member where email = #{email} and birth = #{birth}")
	String selectId(MemberDTO dto);

	@Update("update member set userpw = #{userpw} where userid = #{userid} and email = #{email} and birth = #{birth}")
	int renewPassword(MemberDTO dto);

	@Select("select * from member where userid = #{userid}")
	MemberDTO selectMemberUsingId(String userid);

	

	
	
}
