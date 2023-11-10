package com.lec.ch14.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;

@Service
public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp schEmp);
}
