package com.warumono.repositories;


import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.warumono.databases.public_.tables.Author;
import com.warumono.databases.public_.tables.AuthorBook;
import com.warumono.databases.public_.tables.records.AuthorRecord;
import com.warumono.models.AuthorModel;

@Repository
public class AuthorRepository
{
	Author author = Author.AUTHOR;
	AuthorBook authorBook = AuthorBook.AUTHOR_BOOK;
	
	@Autowired
	private DSLContext dsl;
	
	@Transactional
	public Long insert(AuthorModel authorModel)
	{
		AuthorRecord authorRecord = dsl.insertInto(author, author.FIRST_NAME, author.LAST_NAME)
			.values(authorModel.getFirstName(), authorModel.getLastName())
			.returning(author.ID)
			.fetchOne();
		
		return authorRecord.getValue(author.ID);
	}
	
	@Transactional
	public boolean update(AuthorModel authorModel)
	{
		return dsl.update(author)
				.set(author.FIRST_NAME, authorModel.getFirstName())
				.set(author.LAST_NAME, authorModel.getLastName())
				.where(author.ID.eq(authorModel.getId()))
				.execute() == 1;
	}
	
	@Transactional
	public boolean delete(Long id)
	{
		return dsl.deleteFrom(author)
				.where(author.ID.eq(id))
				.execute() == 1;
	}
	
	@Transactional(readOnly = true)
	public List<com.warumono.databases.public_.tables.pojos.Author> selectAll()
	{
		return dsl.selectFrom(author)
				.fetchInto(com.warumono.databases.public_.tables.pojos.Author.class);
	}
	
	@Transactional(readOnly = true)
	public com.warumono.databases.public_.tables.pojos.Author selectOneById(Long id)
	{
		return dsl.selectFrom(author)
				.where(author.ID.eq(id))
				.fetchOneInto(com.warumono.databases.public_.tables.pojos.Author.class);
	}
}
