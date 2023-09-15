package com.lec.member;

import java.sql.Date;

import com.sun.jmx.snmp.Timestamp;

public class TestMain {
	public static void main(String[] args) {
		MemberDao mDao = MemberDao.getInstance();
		String id = "JANG";
		String pw = "111";
		System.out.println(mDao.loginCheck(id, pw));
		System.out.println(mDao.confirmID("JAN"));
		System.out.println(mDao.joinMember(new MemberDto("HAN","222","장길동","010","6666","5555","m","han@han.com",new Date(2023, 1, 15),"서울마포구",null)));
		
	}
	
}
