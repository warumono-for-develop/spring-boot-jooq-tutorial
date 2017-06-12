package com.warumono.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warumono.databases.public_.tables.pojos.Author;
import com.warumono.databases.public_.tables.pojos.AuthorBook;
import com.warumono.models.AuthorModel;
import com.warumono.services.AuthorBookService;
import com.warumono.services.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/author")
public class AuthorController
{
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AuthorBookService authorBookService;
	
	@GetMapping(value = "test")
	public ResponseEntity<String> test()
	{
		log.debug("===== test =====");
		
		return ResponseEntity.ok("Hello, Tester!");
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Author> save(@RequestBody(required = true) AuthorModel authorModel)
	{
		log.debug("===== save ===== {}", authorModel);
		
		Author author = authorService.save(authorModel);
		
		log.debug("{}", author);
		
		return ResponseEntity.ok(author);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<Author> edit(@RequestBody(required = true) AuthorModel authorModel)
	{
		log.debug("===== edit ===== {}", authorModel);
		
		Author author = authorService.edit(authorModel);
		
		log.debug("{}", author);
		
		return ResponseEntity.ok(author);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Author> remove(@PathVariable(value = "id") Long id)
	{
		log.debug("===== remove ===== {}", id);
		
		Author author = authorService.remove(id);
		
		log.debug("{}", author);
		
		return ResponseEntity.ok(author);
	}
	
	@GetMapping(value = "")
	public ResponseEntity<List<Author>> all()
	{
		log.debug("===== all =====");
		
		List<Author> authors = authorService.getAll();
		
		return ResponseEntity.ok(authors);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Author> author(@PathVariable(value = "id") Long id)
	{
		log.debug("===== author ===== {}", id);
		
		Author author = authorService.getOneById(id);
		
		return ResponseEntity.ok(author);
	}
	
	@GetMapping(value = "{id}/book")
	public ResponseEntity<List<AuthorBook>> authorbook(@PathVariable(value = "id") Long id)
	{
		log.debug("===== authorbook ===== {}", id);
		
		List<AuthorBook> authorBooks = authorBookService.getByAuthorId(id);
		
		return ResponseEntity.ok(authorBooks);
	}
}
