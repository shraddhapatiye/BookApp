package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.dao.BookDAO;
import com.bookapp.dao.BookDAOImpl;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {
	BookDAO bookDAO=new BookDAOImpl();

	public void addBook(Book book) {
	bookDAO.addOneBook(book);

	}

	public void updateBook(int bookid, double price) throws IdNotFoundException {
		int result = bookDAO.updateOneBook(bookid, price); 
		if(result == 0)
			throw new IdNotFoundException("Invalid id");	
	
	}

	public void deleteBook(int bookid) throws IdNotFoundException {
		int result = bookDAO.deleteOneBook(bookid);
		if(result == 0)
			throw new IdNotFoundException("Id not found");

	}

	public Book getBookById(int bookid) throws IdNotFoundException {
		Book book=bookDAO.findBookById(bookid);
		if(book==null)
			throw new IdNotFoundException("Invalid iD");
		return book;
	}

	public List<Book> getAllBooks() {
		return bookDAO.findAllBooks()
		.stream()
		.sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
		.collect(Collectors.toList());
		
	}

	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
	List<Book> bookList=bookDAO.findBookByAuthor(author);
	if(bookList.isEmpty())
		throw new AuthorNotFoundException("Author not found");
		return bookList;
	}

	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> bookList=bookDAO.findBookByCategory(category);
		if(bookList.isEmpty())
			throw new CategoryNotFoundException("Category not found");
			return bookList;
		
	}

}
