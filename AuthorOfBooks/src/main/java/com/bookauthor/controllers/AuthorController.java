package com.bookauthor.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookauthor.entity.Book;
import com.bookauthor.service.AuthorService;

@RestController
public class AuthorController {
	
	Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/{author}")
	public List<Book> getBooksByAuthor(@PathVariable("author") String author){
		
		List<Book> books = authorService.getBooks(author);
		
		return books;
		
		
	}
	
	@GetMapping("/search/{startname}")
	public List<Book> getBooksSearched(@PathVariable("startname") String startname){
		
		System.out.println(startname);
		
		List<Book> books = authorService.getBooksBySearch(startname);
		
		return books;
		
		
	}
	
	
	
	

}
