package com.javatechie.jpa.querydsl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorStatistic {
    private String authorName;
    private Long bookSize;
}
