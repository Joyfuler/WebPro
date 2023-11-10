package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch14.dto.Emp;

@Mapper
public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);	
	// parameterType = "Emp"가 List의 타입으로 들어감.
}
