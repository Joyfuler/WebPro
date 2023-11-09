package com.lec.ch12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch12.service.FileUpService;

@Controller
public class FileController {
	@Autowired
	private FileUpService fileUpService;
	
	@RequestMapping(value = "fileup", method = RequestMethod.GET)
	public String fileup() {
		return "fileup";
	}
	
	@RequestMapping(value = "fileup", method = RequestMethod.POST)
	public ModelAndView fileup(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		if (fileUpService.fileUp(mRequest, mav)) {
			// 파일이 업로드 되었다면
			mav.addObject("fileUpResult", "파일 업로드 성공");
		} else {
			mav.addObject("fileUpResult", "파일 업로드 실패");
		}
		mav.setViewName("fileResult");
		// 이후 fileResult.jsp 에서 fileUpResult와 fileNames를 출력
		return mav;
	}
}
