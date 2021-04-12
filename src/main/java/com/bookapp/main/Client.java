package com.bookapp.main;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {
		BookService service=new BookServiceImpl();
		service.getAllBooks().forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("By author ");
		try {
			service.getBookByAuthor("Ram").forEach(System.out::println);
		} catch (AuthorNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
        System.out.println("By category ");
			try {
				service.getBookByCategory("self").forEach(System.out::println);
			} catch (CategoryNotFoundException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
			System.out.println("By Id ");
			try {
				Book book=service.getBookById(12);
				System.out.println(book);
			} catch (IdNotFoundException e) {
			  System.out.println(e.getMessage());
			}
	}
	

}
