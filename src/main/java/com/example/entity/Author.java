package com.example.entity;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;


import jakarta.persistence.*;


@Entity
public class Author {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private Date birthdate;

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Book> books;

	    
	    
	    
}
