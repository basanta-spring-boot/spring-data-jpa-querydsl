package com.javatechie.jpa.querydsl.repository.impl;

import com.javatechie.jpa.querydsl.domain.Book;
import com.javatechie.jpa.querydsl.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
@Repository
public class BookRepositoryImpl extends BaseRepositoryImpl<Book,Integer> implements BookRepository {

    public BookRepositoryImpl(EntityManager em) {
        super(Book.class, em);
    }
}
