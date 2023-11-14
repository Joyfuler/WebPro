package com.lec.ch19.vo;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Book {
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate;
	private String bimg1;
	private String bimg2;
	private String binfo;
	private int startRow;
	private int endRow;
	// 검색을 위한 필드
	private String schItem; //검색조건 선택, 책이름+저자 / 책이름 / 저자
	private String schWord; // 검색어.
}
