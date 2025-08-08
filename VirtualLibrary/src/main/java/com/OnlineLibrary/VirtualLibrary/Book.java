package com.OnlineLibrary.VirtualLibrary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book 
{
   @Id @GeneratedValue
   private long bkid;
   private String bkname;
   private String bkauth;
   private boolean available;
   private int quantity;
   private String genre;

 
   public Book(long bkid, String bkname, String bkauth, boolean available, int quantity, String genre) {
	super();
	this.bkid = bkid;
	this.bkname = bkname;
	this.bkauth = bkauth;
	this.available = available;
	this.quantity = quantity;
	this.genre = genre;
}
   public Book() {}
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
