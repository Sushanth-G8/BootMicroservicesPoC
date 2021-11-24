package com.bookauthor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bookauthor.entity.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	
		
    Book book = new Book();
		
		book.setId(rs.getInt("id"));
		book.setName(rs.getString("name"));
		book.setCategory(rs.getString("category"));
		book.setPrice(rs.getInt("price"));
		book.setAuthor(rs.getString("author"));
			
			
			return book;
	}

	
	}


