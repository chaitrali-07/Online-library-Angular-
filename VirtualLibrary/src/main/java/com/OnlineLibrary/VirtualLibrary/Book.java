package com.OnlineLibrary.VirtualLibrary;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book") 
public class Book 
{
   @Id @GeneratedValue
   private long bkid;
   private String bkname;
   private String bkauth;
   private boolean available;
   @Column(name = "totalquantity")
   private int totalQuantity;
   private int quantity;
   private String genre;
   private LocalDate borrowDate;
   private LocalDate returnDate;
   private String borrowedBy;
 
   public Book(long bkid, String bkname, String bkauth, boolean available, int totalQuantity, int quantity, String genre,
		LocalDate borrowDate, LocalDate returnDate, String borrowedBy) {
	super();
	this.bkid = bkid;
	this.bkname = bkname;
	this.bkauth = bkauth;
	this.available = available;
	this.totalQuantity = totalQuantity;
	this.quantity = quantity;
	this.genre = genre;
	this.borrowDate = borrowDate;
	this.returnDate = returnDate;
	this.borrowedBy = borrowedBy;
}
   public Book() {}
   public int getTotalQuantity() {
		return totalQuantity;
	}
	   public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	   }
   public int getQuantity() {
	return quantity;
}
   public void setQuantity(int quantity) {
	this.quantity = quantity;
   }
   public String getGenre() {
	return genre;
   }
   public void setGenre(String genre) {
	this.genre = genre;
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
   public String getBorrowedBy() {
	return borrowedBy;
   }
   public void setBorrowedBy(String borrowedBy) {
	this.borrowedBy = borrowedBy;
   }
   public long getBkid() {
	return bkid;
   }
   public void setBkid(long bkid) {
	this.bkid = bkid;
   }
   public String getBkname() {
	return bkname;
   }
   public void setBkname(String bkname) {
	this.bkname = bkname;
   }
   public String getBkauth() {
	return bkauth;
   }
   public void setBkauth(String bkauth) {
	this.bkauth = bkauth;
   }
   public boolean isAvailable() {
	return available;
   }
   public void setAvailable(boolean available) {
	this.available = available;
   }
   
   
}
