package com.lec.ch15.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch15.dto.Dept;
import com.lec.ch15.dto.Emp;
import com.lec.ch15.util.Paging;

@Mapper
public interface EmpService {
	public List<Dept> deptList(); // 반드시출력
	public List<Emp> empList(String pageNum);
	public List<Emp> empDeptList(String pageNum); // 페이징을 위해 pageNum 매개변수를 투입.	
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public void dummyDataInsert50(); // 더미데이터 넣는 메소드가 필요하다고 느끼다면 자유롭게 추가가능.
}
