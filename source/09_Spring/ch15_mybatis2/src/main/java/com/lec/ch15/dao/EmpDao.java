package com.lec.ch15.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch15.dto.Emp;

@Mapper
public interface EmpDao {
	// emp.xml에서 실행되는 함수를 모조리 옮긴다
	public List<Emp> empList(Emp emp);
	public List<Emp> empDeptList(Emp emp);
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
}
