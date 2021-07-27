package com.mx.BookSystem.bean;

import java.sql.*;

public class Borrow {
	private String userId,bookId,bookName,author;
	private Date borrowTime,returnTime;
	public Borrow(String userId, String bookId, String bookName, String author, Date borrowTime, Date returnTime) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	@Override
	public String toString() {
		return "Borrow [userId=" + userId + ", bookId=" + bookId + ", bookName=" + bookName + ", author=" + author
				+ ", borrowTime=" + borrowTime + ", returnTime=" + returnTime + "]";
	}

}
