package com.itbank.board;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
	@Insert("insert into board (username, password, email) "
			+ "values (#{username}, #{password}, #{email})")
	int insertUser(UserDTO dto);
}
