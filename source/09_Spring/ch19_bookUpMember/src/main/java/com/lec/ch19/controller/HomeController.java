package com.lec.ch19.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.service.BookService;
import com.lec.ch19.service.MemberService;
import com.lec.ch19.vo.Book;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	@Autowired
	public BookService bookService;
	@Autowired
	public MemberService memberService;
	
	@RequestMapping(value = "main", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(Model model, Book book, String pageNum) {
		model.addAttribute("mainList", bookService.mainList());
		model.addAttribute("book", bookService.bookList(book, pageNum));
		return "main/main";		
	}	
}
