package com.bookstore.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
public class BookController {
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/login")
	public String login() {
		
		logger.info("Inside Login Controller");
		return "login-page";
		
		}
	
	
	@GetMapping("/user")
	public String customer() {
		
		logger.info("Inside user Controller");
		
		return "user-login-page";
		
		
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		
		logger.info("Inside admin login Controller");
		return "admin-login-page";
		
		
	}
	
	
	@GetMapping("/adminoperations")
	
	public String adminOperations(@RequestParam("userName") String name) {
		
	    if(name.equalsIgnoreCase("Sushanth")) {
		
		logger.info("Inside adminOperations Controller");
		
		return "admin-Operations";
	    }
	    
	    else {
	    	
	    	logger.error("Enter Correct Credentials");
	    	
	    	return "Enter Correct Credentials";
	    }
		
	}
	
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		
		logger.info("Inside AddBook Controller");
		
		model.addAttribute("book", new Book());
		
		return "add-book";
	}
	
	@PostMapping("/savebook")
	@ResponseBody
	public String saveBook(@Valid Book book) throws BookAvailableException {
		
		logger.info("Inside Save Book Controller");
		
		/*
		 * List<Book> bookList = bookService.loadBooks(); for(Book b:bookList) {
		 * 
		 * if(b.getName().equalsIgnoreCase(book.getName())) throw new
		 * BookAvailableException("Book Already Available"); }
		 */
		
		
		if(book.getId()>1000) {
		
		bookService.saveBook(book);
		}
		else {
			return "Please enter Correct BookID Details";
		}
		
		return " Record Saved Successfully";
	}
	
	@GetMapping(value = "/books")
	public String showBookList(Model model){
		
		logger.info("Inside Booking Controller");
		
		List<Book> bookList = bookService.loadBooks();
		
		logger.info("List" +bookList);
		
		model.addAttribute("books", bookList);
		
		return "book-list";
}
	
	
	@GetMapping(value = "/readandupdatebooks")
	public String readAndUpdateBooks(Model model){
		
		logger.info("Inside read&Update Controller");
		
		List<Book> bookList = bookService.loadBooks();
		
		logger.info("List" +bookList);
		
		model.addAttribute("books", bookList);
		
		return "read-update-books";
}
	
	@GetMapping("/updatebook")
	public String updateBook(@RequestParam("bookid") int id, Model model){
		
		logger.info("Inside Update Book Controller");
		logger.info("Updated Hotel ID: " +id);
		
		Optional<Book> updatedBook= bookService.getBook(id);
		
		
		model.addAttribute("book",updatedBook);
		
		
		
		return "update-hotel";
		
	}
	
	@GetMapping("/deletebook")
	public String deleteHotel(Model model) {
		
		logger.info("Inside Delete Book Controller");
		
		return "delete-book";
	}
	
	@GetMapping("/deletedata")
	@ResponseBody
	public String deleteData(@RequestParam("bookid") int id,Book book) throws BookNotFoundException{
		
		logger.info("Inside Delete Data Controller");
		logger.info("Book ID is :"+ id);
		
		bookService.deleteData(id); 
		
		
		return " Record Deleted Successfully";
	}
	
	@GetMapping("/booksbyauthor")
	public String booksByAuthor(@RequestParam("author") String author, Model model){
		
		logger.info("Inside BooksbyAuthor Controller");
		logger.info("Author Selected : " +author);
		
		List<Book> bookList= bookService.getbooksByAuthor(author);
		
		logger.info("Books by" + author +"are" +bookList );
		model.addAttribute("books",bookList);
		model.addAttribute("authorSelected", author);
		
		
		
		return "Books-by-author";
		
	}
	
	@GetMapping("/searchbooks")
	public String searchBooks(@RequestParam("booksearch") String startname,Model model) {
		
		logger.info("Searched Book starts with" +startname);
		
		List<Book> bookswithName = bookService.getBookBySearch(startname);
		
		logger.info("Books with Search name  :" +bookswithName);
		
		model.addAttribute("books",bookswithName);
		model.addAttribute("search",startname);
		
		return "Book-Search";
		
		
	}

}
