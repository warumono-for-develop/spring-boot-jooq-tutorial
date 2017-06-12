package com.warumono.repositories;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.warumono.databases.public_.tables.Book;
import com.warumono.databases.public_.tables.records.BookRecord;
import com.warumono.models.BookModel;

@Transactional
@Repository
public class BookRepository
{
	Book book = Book.BOOK;
	
	@Autowired
	private DSLContext dsl;


	public Long insert(BookModel bookModel)
	{
		BookRecord bookRecord = dsl.insertInto(book, book.TITLE)
				.values(bookModel.getTitle())
				.returning(book.ID)
				.fetchOne();
		
		return bookRecord.getValue(book.ID);
	}
	
	public boolean update(BookModel bookModel)
	{
		return dsl.update(book)
				.set(book.TITLE, "")
				.where(book.ID.eq(1L))
				.execute() == 1;
	}
	
	public boolean delete(Long id)
	{
		return dsl.deleteFrom(book)
				.where(book.ID.eq(id))
				.execute() == 1;
	}
	
	public List<com.warumono.databases.public_.tables.pojos.Book> selectAll()
	{
		return dsl.selectFrom(book)
				.fetchInto(com.warumono.databases.public_.tables.pojos.Book.class);
	}
	
	public com.warumono.databases.public_.tables.pojos.Book selectOneById(Long id)
	{
		return dsl.selectFrom(book)
				.where(book.ID.eq(id))
				.fetchOneInto(com.warumono.databases.public_.tables.pojos.Book.class);
	}
}
