package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Author;
import com.example.service.AuthorServices;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	   @Autowired
	    private AuthorServices authorService;

	    @PostMapping
	    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
	        return ResponseEntity.status(201).body(authorService.saveAuthor(author));
	    }

	    @GetMapping
	    public List<Author> getAllAuthors() {
	        return authorService.getAllAuthors();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
	        return authorService.getAuthorById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.status(404).build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
	        authorService.deleteAuthorById(id);
	        return ResponseEntity.status(204).build();
	    }
	


	
	
	
	

}
