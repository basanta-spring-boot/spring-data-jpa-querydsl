package com.javatechie.jpa.querydsl.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private int authorId;
    private String name;
    private String email;
    @OneToMany(targetEntity = Book.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "authorId")
    private List<Book> books;
}
