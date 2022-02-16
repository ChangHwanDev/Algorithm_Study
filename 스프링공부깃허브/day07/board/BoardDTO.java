package com.it.board;

import java.sql.Date;

//	TABLE : BOARD
//	IDX       NOT NULL NUMBER         
//	TITLE     NOT NULL VARCHAR2(100)  
//	WRITER    NOT NULL VARCHAR2(50)   
//	CONTENT   NOT NULL VARCHAR2(2000) 
//	WRITEDATE          DATE           
//	VIEWCOUNT          NUMBER 
public class BoardDTO {
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	private int viewCount;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
}
