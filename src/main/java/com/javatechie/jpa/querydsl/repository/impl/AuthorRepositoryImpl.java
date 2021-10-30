package com.javatechie.jpa.querydsl.repository.impl;

import com.javatechie.jpa.querydsl.domain.Author;
import com.javatechie.jpa.querydsl.dto.AuthorStatistic;
import com.javatechie.jpa.querydsl.repository.AuthorRepository;
import com.querydsl.core.types.Projections;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {


    public AuthorRepositoryImpl(EntityManager em) {
        super(Author.class, em);
    }


    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        return Optional.ofNullable(
                queryFactory
                        .select(author)
                        .from(author)
                        .where(author.email.equalsIgnoreCase(email))
                        .fetchFirst());
    }

    @Override
    public List<AuthorStatistic> findAuthorStatistic() {
        return queryFactory
                .from(author)
                .innerJoin(author.books, book)
                .groupBy(author.name)
                .select(Projections
                        .constructor(AuthorStatistic.class,
                                author.name, book.count()
                        )
                ).fetch();
    }

    @Override
    public List<Author> findAllWithBooks() {
        return queryFactory
                .select(author)
                .distinct()
                .from(author)
                .innerJoin(author.books, book)
                .fetchJoin().fetch();
    }
}
