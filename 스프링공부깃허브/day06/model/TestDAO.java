package com.jch.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	//기존의 jdbcTemplate을 대체하는 객체 (mybatis)
	@Autowired private SqlSessionTemplate sst;
	
	public String selectVersion() {
//		String sql = "select * from v$version";
		String version = sst.selectOne("TestDAO.version");
		return version;
	}
}
