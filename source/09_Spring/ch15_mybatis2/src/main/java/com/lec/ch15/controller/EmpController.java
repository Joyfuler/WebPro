package com.lec.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.dto.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		//empList.do 또는 empList.do?pageNum=2
		// view단에는 페이징 기능과 list를 출력해야 하므로 model도 필요.
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		// 이후 view단에서 ${Paging.totCnt } 등으로 사용할 수 있다. 
		model.addAttribute("empList", empService.empList(pageNum));
		return "empList";
	}
	@RequestMapping(value = "dummyInsert50", method = RequestMethod.GET)
	public String dummy() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	
	@RequestMapping(value = "empDeptList", method = {RequestMethod.GET, RequestMethod.POST})
	public String empDeptList(String pageNum, Model model) {
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		model.addAttribute("empDeptList", empService.empDeptList(pageNum));
		return "empDeptList";
	}
	
	// 해당사원 상세정보. empno로 empDto 반환
	@RequestMapping(value = "detail", method = {RequestMethod.GET, RequestMethod.POST})
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";			
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(int empno, String pageNum, Model model) {
		model.addAttribute("deptList", empService.deptList()); // 몇번부서인지 선택하게하려면 부서정보 넘겨줘야함.
		model.addAttribute("empDto", empService.detail(empno)); // 수정할 사원의 정보를 넘겨줌.
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Emp emp, Model model) {
		// model은 수정 이후에 alert뿌려주는 용도.
		model.addAttribute("modifyResult", empService.update(emp));
		return "forward:detail.do"; // 패러미터인 empno는 Emp emp에 있으므로 자동으로 부착된다.
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	
	
	@RequestMapping(value = "write", method =RequestMethod.GET)
	public String write(Model model) {
		// 작성하는 페이지로 이동함. 관리자 및 부서 리스트는 선택할 수 있도록 전달함.
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "write";
	}
	
	@RequestMapping(value = "confirmNo", method = RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if (empService.detail(empno) == null) { // 해당 empno에 대응하는 사람이 없는 경우. 중복 x
			model.addAttribute("confirmMsg", "사용가능한 사번입니다");
		} else {
			model.addAttribute("confirmMsg", "사용불가능한 사번입니다");
		}
		return "forward:write.do";		
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Emp emp, Model model) {
		System.out.println(emp);
		model.addAttribute("writeResult", empService.insert(emp));
		return "forward:empDeptList.do";
	}
	
	
}
