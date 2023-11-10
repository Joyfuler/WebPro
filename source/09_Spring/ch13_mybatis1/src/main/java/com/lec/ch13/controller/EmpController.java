package com.lec.ch13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.ch13.dto.Dept;
import com.lec.ch13.dto.Emp;
import com.lec.ch13.service.EmpService;

@Controller
public class EmpController {	
	@Autowired
	private EmpService empService;
	@ModelAttribute("deptList")
	// 어떤 요청경로가 오든, deptList는 반드시 출력함
	public List<Dept> deptList(){
		return empService.deptList();
	}
	// emp.do인 경우. 위의 deptList는 실행됨
	@RequestMapping(value = "emp")
	public String emp(@ModelAttribute("searchEmp") Emp emp, Model model) {		
		model.addAttribute("empList", empService.empList(emp));
		return "emp";
	}
}
