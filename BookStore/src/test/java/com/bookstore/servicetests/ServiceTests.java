package com.bookstore.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@SpringBootTest
public class ServiceTests {
	
	@InjectMocks
	BookService bookService;
	
	@Mock
	BookRepository repository;
	
	@Test
	public void testFindAllBooks() {
		
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(2001,"HumanGeography","Social",250,"Leong"));
		books.add(new Book(2002,"Kargil","Novel",300,"RachnaBisht"));
		when(repository.findAll()).thenReturn(books);
		List<Book> bookList= bookService.loadBooks();
		
		
		assertEquals(2, bookList.size() );
		verify(repository, times(1)).findAll();
		

		Assertions.assertThat(bookList).extracting(Book::getId).contains(2002);
		
		
		}
	
	

}
