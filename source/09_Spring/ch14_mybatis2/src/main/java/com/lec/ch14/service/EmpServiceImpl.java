package com.lec.ch14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch14.dao.DeptDao;
import com.lec.ch14.dao.EmpDao;
import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;	
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}

	@Override
	public List<Emp> empList(Emp schEmp) { // Emp는 emp.xml에서 설정한 parameterType
		// Controller에서는 검색한 단어들이 Emp 타입으로 들어온다.
		// emp.do 로 들어왔다면 검색어(schEmp)가 들어오지 않았음.
		// emp.do? ename=s&deptno=0으로 들어왔다면 이를 schEmp.ename을 s로 받는것.
		
		// emp.do?ename=s 등으로 패러미터가 넘어왔을 때, 들어온 패러미터를 대문자로 변경해서 반환한다.
		if (schEmp.getEname() != null) {
			schEmp.setEname(schEmp.getEname().toUpperCase());
		}
		
		if (schEmp.getJob() != null) {
			schEmp.setJob(schEmp.getJob().toUpperCase());
		}
		
		return empDao.empList(schEmp);
		// 검색어를 넣거나 or 넣지 않음. 어느 쪽이든 schEmp에 담고 empList를 출력.
	}

}
