package com.bookauthor.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookauthor.entity.Book;

@Repository
public class AuthorDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public List<Book> getBooksByAuthor(String author) {
		
		String sql = "SELECT * FROM books where author= ?";
		
		
		  List<Book> bookList = jdbcTemplate.query(sql,new Object[]{author}, new BookRowMapper());
		
		return bookList;
		
		

	}


	public List<Book> getBooksbySearching(String startname) {
		
		System.out.println("Inside Search DAO");
		
		String sql= "SELECT * FROM books where name LIKE '%"+startname+"%'";
		
		
		System.out.println(sql);
		
		
		  List<Book> bookList = jdbcTemplate.query(sql,new BookRowMapper());
		  
		  System.out.println(bookList);
		
		return bookList;
		

	}

}
