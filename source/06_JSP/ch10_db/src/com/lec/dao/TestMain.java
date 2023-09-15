package com.lec.dao;

import java.util.ArrayList;

import com.lec.dto.DeptDto;

public class TestMain {
	
	public static void main(String[] args) {
		DeptDao dao = DeptDao.getInstance();
		ArrayList<DeptDto> deptList = dao.deptList();
		// 출력을 위한 ArrayList타입은 DTO로 설정.
		for (DeptDto deptDto : deptList) { // foreach문
			System.out.println(deptDto);			
		}
	}	
}
