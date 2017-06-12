package com.warumono.repositories;


import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.warumono.databases.public_.tables.Author;
import com.warumono.databases.public_.tables.AuthorBook;
import com.warumono.databases.public_.tables.Book;
import com.warumono.models.AuthorBookModel;

@Repository
public class AuthorBookRepository
{
	Author author = Author.AUTHOR;
	Book book = Book.BOOK;
	AuthorBook authorBook = AuthorBook.AUTHOR_BOOK;
	
	@Autowired
	private DSLContext dsl;
	
	@Transactional
	public boolean insert(AuthorBookModel authorBookModel)
	{
		return dsl.insertInto(authorBook, authorBook.AUTHOR_ID, authorBook.BOOK_ID)
				.values(authorBookModel.getAuthorId(), authorBookModel.getBookId())
				.execute() == 1;
	}
	
	@Transactional
	public boolean update(AuthorBookModel oldAuthorBookModel, AuthorBookModel newAuthorBookModel)
	{
		return dsl.update(authorBook)
				.set(authorBook.AUTHOR_ID, newAuthorBookModel.getAuthorId())
				.set(authorBook.AUTHOR_ID, newAuthorBookModel.getBookId())
				.where(authorBook.AUTHOR_ID.eq(oldAuthorBookModel.getAuthorId()))
				.and(authorBook.BOOK_ID.eq(oldAuthorBookModel.getBookId()))
				.execute() == 1;
	}
	
	@Transactional
	public boolean deleteByAuthorId(Long authorId)
	{
		return dsl.deleteFrom(authorBook)
				.where(authorBook.AUTHOR_ID.eq(authorId))
				.execute() > 0;
	}
	
	@Transactional
	public boolean deleteByBookId(Long bookId)
	{
		return dsl.deleteFrom(authorBook)
				.where(authorBook.BOOK_ID.eq(bookId))
				.execute() > 0;
	}
	
	@Transactional
	public boolean delete(Long authorId, Long bookId)
	{
		return dsl.deleteFrom(authorBook)
				.where(authorBook.AUTHOR_ID.eq(authorId))
				.and(authorBook.BOOK_ID.eq(bookId))
				.execute() == 1;
	}
	
	@Transactional(readOnly = true)
	public List<com.warumono.databases.public_.tables.pojos.AuthorBook> selectAll()
	{
		return dsl.selectFrom(authorBook)
				.fetchInto(com.warumono.databases.public_.tables.pojos.AuthorBook.class);
	}
	
	@Transactional(readOnly = true)
	public com.warumono.databases.public_.tables.pojos.AuthorBook selectOneById(Long authorId, Long bookId)
	{
		return dsl.selectFrom(authorBook)
				.where(authorBook.AUTHOR_ID.eq(authorId))
				.and(authorBook.BOOK_ID.eq(bookId))
				.fetchOneInto(com.warumono.databases.public_.tables.pojos.AuthorBook.class);
	}
	
	public List<com.warumono.databases.public_.tables.pojos.AuthorBook> selectByAuthorId(Long authorId)
	{
		return dsl.select()
				.from(authorBook)
				.join(author)
					.on(author.ID.eq(authorBook.AUTHOR_ID))
				.where(authorBook.AUTHOR_ID.eq(authorId))
				.fetchInto(com.warumono.databases.public_.tables.pojos.AuthorBook.class);
	}
	
	public List<com.warumono.databases.public_.tables.pojos.AuthorBook> selectByBookId(Long bookId)
	{
		return dsl.select()
				.from(authorBook)
				.join(book)
					.on(book.ID.eq(authorBook.BOOK_ID))
				.where(authorBook.BOOK_ID.eq(bookId))
				.fetchInto(com.warumono.databases.public_.tables.pojos.AuthorBook.class);
	}
}
