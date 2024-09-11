package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	
	List<Book> findByAuthorId(Long authorId);
    boolean existsByIsbn(String isbn);
	
	

}
