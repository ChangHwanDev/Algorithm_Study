package com.itbank.member;
//	create table member (
//	    userid      varchar2(100)   primary key,
//	    userpw      varchar2(255)   not null,
//	    username    varchar2(100)   not null,
//	    email       varchar2(100)   not null,
//	    birth       date            not null,
//	    gender      varchar2(10)    check(gender in ('남성', '여성', '선택안함'))
//	);

import java.sql.Date;

public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date birth;
	private String gender;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
