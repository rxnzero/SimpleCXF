package com.dhlee.cxf.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Book")
public class BookVO implements Serializable {
	private long bookId;
	private String bookName;
	private String author;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("bookId=").append(bookId);
		sb.append(", bookName=").append(bookName);
		sb.append(", author=").append(author);
		return sb.toString();
	}
	

}
