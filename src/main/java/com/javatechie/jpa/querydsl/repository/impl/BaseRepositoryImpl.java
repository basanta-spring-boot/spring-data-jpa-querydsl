package com.javatechie.jpa.querydsl.repository.impl;

import com.javatechie.jpa.querydsl.domain.QAuthor;
import com.javatechie.jpa.querydsl.domain.QBook;
import com.javatechie.jpa.querydsl.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public abstract class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    protected final QAuthor author = QAuthor.author;
    protected final QBook book = QBook.book;

    EntityManager em;
    JPAQueryFactory queryFactory;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) {
        return findById(id)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Entity [%s] with id [%s] was not found in DB", getDomainClass().getSimpleName(), id);
                    return new IllegalArgumentException(errorMessage);
                });
    }

    @Override
    public void clear() {
        em.clear();
    }

    /**
     * Remove the given entity from the persistence context not from db
     **/
    @Override
    public void detach(T entity) {
        em.detach(entity);
    }
}
