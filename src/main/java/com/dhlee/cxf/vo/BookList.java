package com.dhlee.cxf.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Booklist")
public class BookList implements Serializable {
	private List<BookVO> booklist;

	public List<BookVO> getBooklist() {
		if(booklist == null) {
			booklist = new ArrayList<BookVO>();
		}
		return booklist;
	}

	public void setBooklist(List<BookVO> booklist) {
		this.booklist = booklist;
	}
}
