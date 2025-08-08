package com.OnlineLibrary.VirtualLibrary;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowedBooks 
{
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long  id;
  @ManyToOne
  @JoinColumn(name = "book_id")  // creates foreign key column in this table
  private Book book;

  private String borrowerName;

  private LocalDate borrowDate;
  private LocalDate returnDate;
  public BorrowedBooks(long id, Book book, String borrowerName, LocalDate borrowDate, LocalDate returnDate) {
	super();
	this.id = id;
	this.book = book;
	this.borrowerName = borrowerName;
	this.borrowDate = borrowDate;
	this.returnDate = returnDate;
  }
  public long getId() {
	return id;
  }
  public void setId(long id) {
	this.id = id;
  }
  public Book getBook() {
	return book;
  }
  public void setBook(Book book) {
	this.book = book;
  }
  public String getBorrowerName() {
	return borrowerName;
  }
  public void setBorrowerName(String borrowerName) {
	this.borrowerName = borrowerName;
  }
  public LocalDate getBorrowDate() {
	return borrowDate;
  }
  public void setBorrowDate(LocalDate borrowDate) {
	this.borrowDate = borrowDate;
  }
  public LocalDate getReturnDate() {
	return returnDate;
  }
  public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
  }
  
}
