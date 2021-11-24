package com.bookstore.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookstore.controllers.BookNotFoundException;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	Logger logger = Logger.getLogger(BookService.class);
	
	public List<Book> loadBooks(){
		
		return(List<Book>) bookRepository.findAll();
		
	}

	public void saveBook(Book book) {
		
		bookRepository.save(book);
		
	}

	public void deleteData(int id) throws BookNotFoundException {
		if(bookRepository.existsById(id)) { 
			  bookRepository.deleteById(id);
				}
				else {
					throw new BookNotFoundException("Book with Id doesn't exist");
				}
		
	}

	public Optional<Book> getBook(int id) {
		
		Optional<Book> book = bookRepository.findById(id);	
		
		return book;
	}
	
	@HystrixCommand(fallbackMethod = "defaultBooks")
	public List<Book> getbooksByAuthor(String author) {
		
		List<Book> books = restTemplate.exchange("http://Author/{author}", HttpMethod.GET, null, new
		        ParameterizedTypeReference<List<Book>>(){},author).getBody();
		
		logger.info(books);
		return books;
			
	}

	public List<Book> defaultBooks(String author){
		return Arrays.asList(new Book(4000,"DefaultBook","Default",000,"NoAuthor"));
	}
	
	@HystrixCommand(fallbackMethod = "defaultBooks")
	public List<Book> getBookBySearch(String startname) {
	
		
		List<Book> books = restTemplate.exchange("http://Author/search/{startname}", HttpMethod.GET, null, new
		        ParameterizedTypeReference<List<Book>>(){},startname).getBody();
		
		logger.info(books);
		return books;
		
	}
	
	

}
