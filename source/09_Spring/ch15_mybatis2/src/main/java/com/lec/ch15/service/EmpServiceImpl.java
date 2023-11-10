package com.lec.ch15.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch15.dao.DeptDao;
import com.lec.ch15.dao.EmpDao;
import com.lec.ch15.dto.Dept;
import com.lec.ch15.dto.Emp;
import com.lec.ch15.util.Paging;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private DeptDao deptDao;
	@Autowired	
	private EmpDao empDao;
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList(); 
	}

	@Override
	public List<Emp> empList(String pageNum) {
		// empList는 startRow와 endRow계산을 한 후 넣어야 함.
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);
		// totCnt 부분에는 totCnt 메소드, pageNum은 그대로, pageSize, blockSize는 자신이 원하는 숫자 대입
		// 결과 paging에는 startRow와 endRow가 들어간다.
		Emp emp = new Emp(); // emp 객체를 새로 만든 후 startRow와 endRow를 채워서 return함.
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		return empDao.empList(emp);
	}

	@Override
	public List<Emp> empDeptList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);		
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		// start, endRow 넣기까지의 과정은 동일.
		return empDao.empDeptList(emp);
		
	}

	@Override
	public int totCnt() {
		return empDao.totCnt();
	}

	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}

	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}

	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);		
	}

	@Override
	public void dummyDataInsert50() {
		Emp emp = new Emp();
		for (int i = 6000; i< 6050; i++) {
			emp.setEmpno(i);
			if (i % 2 ==0) {
				emp.setEname("홍길동");
				emp.setJob("MANAGER");				
			} else {
				emp.setEname("신길동");
				emp.setJob("SALESMAN");
			}
				emp.setMgr("7369");
				emp.setHiredate(Date.valueOf("2023-11-10"));
				emp.setSal(i);
				emp.setDeptno(30);
				int result = empDao.insert(emp);
				System.out.println(result == 1? i+ "번째 사원 등록 완료" : i+"번째 사원 등록 실패");
		}

	}

}
