package com.lec.ch13.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lec.ch13.dto.Dept;
import com.lec.ch13.dto.Emp;

@Service
public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp schEmp);
}
