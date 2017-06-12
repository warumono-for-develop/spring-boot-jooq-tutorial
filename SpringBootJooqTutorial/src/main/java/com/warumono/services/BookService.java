package com.warumono.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warumono.databases.public_.tables.pojos.Book;
import com.warumono.models.BookModel;
import com.warumono.repositories.BookRepository;

@Service
public class BookService
{
	@Autowired
	private BookRepository bookRepository;

	public Book save(BookModel bookModel)
	{
		Long id = bookRepository.insert(bookModel);
		
		return getOneById(id);
	}
	
	public Book edit(BookModel bookModel)
	{
		bookRepository.update(bookModel);
		
		return getOneById(bookModel.getId());
	}

	public Book remove(Long id)
	{
		bookRepository.delete(id);
		
		return getOneById(id);
	}
	
	public List<Book> getAll()
	{
		return bookRepository.selectAll();
	}
	
	public Book getOneById(Long id)
	{
		return bookRepository.selectOneById(id);
	}
}
