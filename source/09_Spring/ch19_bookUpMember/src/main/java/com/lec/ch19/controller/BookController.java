package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;
import com.lec.ch19.vo.Book;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;	
	
	@RequestMapping(value = "bookList")
	public String bookList(String pageNum, Book book, Model model) {
		Paging paging = new Paging(bookService.totCntBook(book), pageNum, 5, 5);
		model.addAttribute("paging", paging);
		model.addAttribute("bookList", bookService.bookList(book, pageNum));
		return "book/bookList";
	}
	
	@RequestMapping(value = "bookRegister", method = RequestMethod.GET)
	public String register() {
		return "book/bookRegister";
	}
	
	@RequestMapping(value = "bookRegister", method = RequestMethod.POST)
	public String register(Book book, Model model, MultipartHttpServletRequest mRequest) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, book));
		return "forward:bookList.do";
	}
	
	@RequestMapping(value = "bookDetail", method = {RequestMethod.GET,RequestMethod.POST})
	public String bookDetail(int bnum, Model model) {
		model.addAttribute("book", bookService.getDetailBook(bnum));
		return "book/bookDetail";		
	}
	
	@RequestMapping(value = "bookModify", method = RequestMethod.GET)
	public String bookModify(int bnum, Model model) {
		model.addAttribute("book", bookService.getDetailBook(bnum));
		return "book/bookModify";
	}
	
	@RequestMapping(value = "bookModify", method = RequestMethod.POST)
	public String bookModify(Book book, Model model, MultipartHttpServletRequest mRequest) {		
		model.addAttribute("modifyResult", bookService.modifyBook(mRequest, book));		
		return "forward:bookDetail.do";
	}
	
	@RequestMapping(value = "bookDelete", method = RequestMethod.GET)
	public String bookDelete(int bnum, Model model) {
		model.addAttribute("deleteResult", bookService.deleteBook(bnum));
		return "forward:bookList.do";
	}
		
}
