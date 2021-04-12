package com.bookapp.main;

import com.bookapp.exception.IdNotFoundException;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class Admin {

	public static void main(String[] args) {
		

		Book book1 =new Book("JAVA",12,"Jack","Programming",7000.0);
		Book book2 =new Book("PYTHON",13,"Rohn","Programming",9000.0);
		Book book3 =new Book("SPRING",14,"Sam","Programming",10000.0);
		Book book4 =new Book("CSS",15,"John","Programming",15000.0);
		BookService service=new BookServiceImpl();
		
		service.addBook(book1);
		service.addBook(book2);
		service.addBook(book3);
		service.addBook(book4);
		
		try {
			service.deleteBook(4);
		} catch (IdNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			service.updateBook(12, 17000.0);
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
