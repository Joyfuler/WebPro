package com.lec.ch15.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private Date hiredate;
	private int sal;
	private String comm;
	private int deptno;
	private String dname;
	private String loc;
	private int startRow;
	private int endRow;
}	
