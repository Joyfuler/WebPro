package com.lec.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.emp.model.Dept;
import com.lec.emp.model.Emp;
import com.lec.emp.repository.DeptRepository;
import com.lec.emp.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private DeptRepository deptRepository;	
	@Autowired
	private EmpRepository empRepository;
	/*
	 * @Autowired public EmpServiceImpl (DeptRepository deptRepository) {
	 * this.deptRepository = deptRepository; }
	 */
	
	
	@Override
	public List<Dept> deptList() {
		return deptRepository.deptList();
	}

	@Override
	public List<Emp> empList(Emp schEmp) {
		if (schEmp.getEname() != null) {
			// 검색어가 비어있지 않다면
			schEmp.setEname(schEmp.getEname().toUpperCase()); // 대문자로 변경하여 다시 넣어줌
		}
		
		if (schEmp.getJob() != null) {
			schEmp.setJob(schEmp.getJob().toUpperCase()); // 직업명도 대문자로.
		}
		return empRepository.empList(schEmp);
	}

}
