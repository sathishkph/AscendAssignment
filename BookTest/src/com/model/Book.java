package com.model;

import com.Exception.InvalidbookException;

public class Book {
	
private String bookid;
private String authorName;
private int price;
public Book(String bookid, String authorName, int price) throws InvalidbookException {
	super();
	
	if (bookid.startsWith("B") && bookid.length() == 4 && authorName.contains("e") && price >0 ) {
	this.bookid = bookid;
	this.authorName = authorName;
	this.price = price;
	}
	else 
		throw new InvalidbookException("Invalid book");
}


public String getBookid() {
	return bookid;
}

public String getAuthorName() {
	return authorName;
}

public int getPrice() {
	return price;
}


@Override
public String toString() {
	return "Book [bookid=" + bookid + ", authorName=" + authorName + ", price=" + price + "]";
}



}





