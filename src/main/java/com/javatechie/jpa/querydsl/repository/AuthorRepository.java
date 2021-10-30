package com.javatechie.jpa.querydsl.repository;


import com.javatechie.jpa.querydsl.domain.Author;
import com.javatechie.jpa.querydsl.dto.AuthorStatistic;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository  extends BaseRepository<Author,Integer> {

    Optional<Author> findAuthorByEmail(String email);

    List<AuthorStatistic> findAuthorStatistic();

    List<Author> findAllWithBooks();
}
