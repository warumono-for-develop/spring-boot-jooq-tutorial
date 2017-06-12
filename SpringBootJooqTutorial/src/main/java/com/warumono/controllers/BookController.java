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

import com.warumono.databases.public_.tables.pojos.Book;
import com.warumono.models.BookModel;
import com.warumono.services.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/book")
public class BookController
{
	@Autowired
	private BookService bookService;

	@PostMapping(value = "")
	public ResponseEntity<Book> save(@RequestBody(required = true) BookModel bookModel)
	{
		log.debug("===== save ===== {}", bookModel);
		
		Book book = bookService.save(bookModel);
		
		log.debug("{}", book);
		
		return ResponseEntity.ok(book);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<Book> edit(@RequestBody(required = true) BookModel bookModel)
	{
		log.debug("===== edit ===== {}", bookModel);
		
		Book book = bookService.edit(bookModel);
		
		log.debug("{}", book);
		
		return ResponseEntity.ok(book);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Book> remove(@PathVariable(value = "id") Long id)
	{
		log.debug("===== remove ===== {}", id);
		
		Book book = bookService.remove(id);
		
		log.debug("{}", book);
		
		return ResponseEntity.ok(book);
	}
	
	@GetMapping(value = "")
	public ResponseEntity<List<Book>> all()
	{
		log.debug("===== all =====");
		
		List<Book> books = bookService.getAll();
		
		return ResponseEntity.ok(books);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Book> id(@PathVariable(value = "id") Long id)
	{
		log.debug("===== id ===== {}", id);
		
		Book book = bookService.getOneById(id);
		
		return ResponseEntity.ok(book);
	}
}
