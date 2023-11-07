package com.lec.uitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MainController {
	@ModelAttribute("cnt")
	public int totCnt() {
		return 4;
	}
	
	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input() {
		return "input";
	}
	
	@RequestMapping(value = "input", method = RequestMethod.POST)
	public String inputResult(@ModelAttribute("student") StudentDto studentDto, Model model) {
		int total = studentDto.getKor() + studentDto.getEng() + studentDto.getMat();
		double avg = total / 3.0;
		studentDto.setTotal(total);
		studentDto.setAvg(avg);
		model.addAttribute("student", studentDto);
		return "inputResult";
	}
}
