package com.bookauthor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookauthor.dao.AuthorDAO;
import com.bookauthor.entity.Book;

@Service
public class AuthorService {
	
	@Autowired
	AuthorDAO authorDAO;

	public List<Book> getBooks(String author) {
		
		List<Book> bookList = authorDAO.getBooksByAuthor(author);
		return bookList;
		
	}

	public List<Book> getBooksBySearch(String startname) {
		
		System.out.println("Inside Search Service");
		List<Book> books = authorDAO.getBooksbySearching(startname);
		return books;
	}
	


}
