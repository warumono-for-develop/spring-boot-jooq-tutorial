package com.warumono.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warumono.databases.public_.tables.pojos.AuthorBook;
import com.warumono.models.AuthorBookModel;
import com.warumono.repositories.AuthorBookRepository;

@Service
public class AuthorBookService
{
	@Autowired
	private AuthorBookRepository authorBookRepository;

	public AuthorBook save(AuthorBookModel authorBookModel)
	{
		authorBookRepository.insert(authorBookModel);
		
		return getOneById(authorBookModel);
	}
	
	public AuthorBook edit(AuthorBookModel oldAuthorBookModel, AuthorBookModel newAuthorBookModel)
	{
		authorBookRepository.update(oldAuthorBookModel, newAuthorBookModel);
		
		return getOneById(newAuthorBookModel);
	}

	public List<AuthorBook> removeByAuthorId(Long authorId)
	{
		authorBookRepository.deleteByAuthorId(authorId);
		
		return getByAuthorId(authorId);
	}
	
	public List<AuthorBook> removeByBookId(Long bookId)
	{
		authorBookRepository.deleteByBookId(bookId);
		
		return getByBookId(bookId);
	}
	
	public List<AuthorBook> getAll()
	{
		return authorBookRepository.selectAll();
	}
	
	public AuthorBook getOneById(AuthorBookModel authorBookModel)
	{
		return getOneById(authorBookModel.getAuthorId(), authorBookModel.getBookId());
	}
	
	public AuthorBook getOneById(Long authorId, Long bookId)
	{
		return authorBookRepository.selectOneById(authorId, bookId);
	}
	
	public List<AuthorBook> getByAuthorId(Long authorId)
	{
		return authorBookRepository.selectByAuthorId(authorId);
	}
	
	public List<AuthorBook> getByBookId(Long bookId)
	{
		return authorBookRepository.selectByBookId(bookId);
	}
}
