package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bookapp.model.Book;

public class BookDAOImpl implements BookDAO {

public void addOneBook(Book book){
String sql="insert into book values(?,?,?,?,?)";
Connection connection =DBConnection.openConnection();
PreparedStatement statement=null;
try {
	statement = connection.prepareStatement(sql);
	statement.setString(1,book.getTitle());
	statement.setInt(2,book.getBookid());
	statement.setString(3,book.getAuthor());
	statement.setString(4,book.getCategory());
	statement.setDouble(5,book.getPrice());
			statement.execute();
} catch (SQLException e) {
	System.out.println(e.getMessage());
}finally {
	if(statement!=null)
		try {
			statement.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	DBConnection.closeConnection();
 }
}

public int updateOneBook(int bookid, double price){
	String sql="update  Book set price=? where bookid=?";
	Connection connection =DBConnection.openConnection();
	PreparedStatement statement=null;
	int result=0;
	try {
		statement = connection.prepareStatement(sql);
		statement.setDouble(1,price);
		statement.setInt(2,bookid);
		 result = statement.executeUpdate();
		System.out.println(result);
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}finally {
		if(statement!=null)
			try {
				statement.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		DBConnection.closeConnection();
	 }
return result;
}

public int deleteOneBook(int bookid) {
	String sql="delete from  Book  where bookid=?";
	Connection connection =DBConnection.openConnection();
	PreparedStatement statement=null;
	int result=0;
	try {
		statement = connection.prepareStatement(sql);
		statement.setInt(1,bookid);
		 result = statement.executeUpdate();
		System.out.println(result);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(statement!=null)
			try {
				statement.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		DBConnection.closeConnection();
	 }
return result;
}

public Book findBookById(int bookid) {
	String sql="select * from  book where bookid=?";
	Connection connection =DBConnection.openConnection();
	PreparedStatement statement=null;
	Book book=null;
	try {
		statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		statement.setInt(1,bookid);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			String title=rs.getString("title");
			String author1=rs.getString("author");
			String category=rs.getString("category");
			int bookId=rs.getInt(2);
			double price=rs.getDouble("price");
			 book=new Book(title,bookId,author1,category,price);
			
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}finally {
		if(statement!=null)
			try {
				statement.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		DBConnection.closeConnection();
	 }
	return book;
		
	}


public List<Book> findAllBooks() {
	String sql="select * from  Book";
	Connection connection =DBConnection.openConnection();
	PreparedStatement statement=null;
	List<Book> bookList=new ArrayList<>();
	try {
		statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			String title=rs.getString("title");
			String author=rs.getString("author");
			String category=rs.getString("category");
			int bookId=rs.getInt(2);
			double price=rs.getDouble("price");
			Book book=new Book(title,bookId,author,category,price);
			bookList.add(book);
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}finally {
		if(statement!=null)
			try {
				statement.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		DBConnection.closeConnection();
	 }
	return bookList;

}
	
public List<Book> findBookByAuthor(String author){
String sql="select * from  book where author=?";
Connection connection =DBConnection.openConnection();
PreparedStatement statement=null;
List<Book> bookList=new ArrayList<>();
try {
	statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	statement.setString(1,author);
	ResultSet rs =statement.executeQuery();
	while(rs.next()){
		String title=rs.getString("title");
		String author1=rs.getString("author");
		String category=rs.getString("category");
		int bookId=rs.getInt(2);
		double price=rs.getDouble("price");
		Book book=new Book(title,bookId,author1,category,price);
		bookList.add(book);
	}
	
} catch (SQLException e) {
	System.out.println(e.getMessage());
}finally {
	if(statement!=null)
		try {
			statement.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	DBConnection.closeConnection();
 }
return bookList;
	
}
public List<Book> findBookByCategory(String category) {
	String sql="select * from  book where category=?";
	Connection connection =DBConnection.openConnection();
	PreparedStatement statement=null;
	List<Book> bookList=new ArrayList<>();
	try {
		statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		statement.setString(1,category);
		ResultSet rs=statement.executeQuery();
		
		while(rs.next()){
			String title=rs.getString("title");
			String author1=rs.getString("author");
			String category1=rs.getString("category");
			int bookId=rs.getInt(2);
			double price=rs.getDouble("price");
			Book book=new Book(title,bookId,author1,category1,price);
			bookList.add(book);
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}finally {
		if(statement!=null)
			try {
				statement.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		DBConnection.closeConnection();
	 }
	return bookList;
		
	}
}

