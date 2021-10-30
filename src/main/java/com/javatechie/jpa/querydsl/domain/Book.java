package com.javatechie.jpa.querydsl.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private int bookId;
    private String name;
    private String iban;

}
