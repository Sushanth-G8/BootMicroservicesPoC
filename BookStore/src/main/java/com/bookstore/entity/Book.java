package com.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	private Integer id;
	
	@NotNull(message = "Name is mandatory")
	@Size(min = 3,max = 30 )
	private String name;
	@NotNull
	@Size(min=2, message = "Enter more than 3 characters")
	private String category;
	@NotNull
	private Integer price;
	@NotNull
	@Size(min=3)
	private String author;
	public Book() {
		super();
		
	}
	public Book(Integer id, String name, String category, Integer price, String author) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.author = author;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", author="
				+ author + "]";
	}
	
	

}
