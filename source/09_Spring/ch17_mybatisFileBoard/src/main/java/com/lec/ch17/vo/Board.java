package com.lec.ch17.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Board {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private String bfile;
	private Date bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private int startRow;
	private int endRow;
}
