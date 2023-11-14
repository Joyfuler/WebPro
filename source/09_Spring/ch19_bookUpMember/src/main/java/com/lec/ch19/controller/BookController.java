package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.repository.BookDao;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;
import com.lec.ch19.vo.Book;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;	
	
	@RequestMapping(value = "bookList")
	public String bookList(Book book, String pageNum, Model model) {
		Paging paging = new Paging(bookService.totCntBook(), pageNum, 5, 5);
		model.addAttribute("paging", paging);
		model.addAttribute("bookList", bookService.bookList(pageNum));
		return "book/bookList";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "book/bookRegister";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Book book, Model model, MultipartHttpServletRequest mRequest) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, book));
		return "forward:bookList.do";
	}
	
	
}
