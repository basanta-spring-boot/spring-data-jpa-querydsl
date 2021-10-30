package com.javatechie.jpa.querydsl.controller;

import com.javatechie.jpa.querydsl.domain.Author;
import com.javatechie.jpa.querydsl.domain.Book;
import com.javatechie.jpa.querydsl.dto.AuthorStatistic;
import com.javatechie.jpa.querydsl.repository.AuthorRepository;
import com.javatechie.jpa.querydsl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class AuthorBookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/authors")
    public List<Author> saveAuthorWithBooks(@RequestBody List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/author/{email}")
    public Optional<Author> findAuthorByEmail(@PathVariable String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    @GetMapping("/author/book/counts")
    public List<AuthorStatistic> getAuthorNameAndBookCounts() {
        return authorRepository.findAuthorStatistic();
    }

    @GetMapping("/authors/fetchJoin")
    public List<Author> getAuthorsWithFetchJoin() {
        return authorRepository.findAllWithBooks();
    }

}
