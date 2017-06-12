package com.warumono.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warumono.databases.public_.tables.pojos.Author;
import com.warumono.models.AuthorModel;
import com.warumono.repositories.AuthorRepository;

@Service
public class AuthorService
{
	@Autowired
	private AuthorRepository authorRepository;

	public Author save(AuthorModel authorModel)
	{
		Long id = authorRepository.insert(authorModel);
		
		return getOneById(id);
	}
	
	public Author edit(AuthorModel authorModel)
	{
		authorRepository.update(authorModel);
		
		return getOneById(authorModel.getId());
	}

	public Author remove(Long id)
	{
		authorRepository.delete(id);
		
		return getOneById(id);
	}
	
	public List<Author> getAll()
	{
		return authorRepository.selectAll();
	}
	
	public Author getOneById(Long id)
	{
		return authorRepository.selectOneById(id);
	}
}
