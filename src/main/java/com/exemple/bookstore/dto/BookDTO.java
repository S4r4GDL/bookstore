package com.exemple.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {

    private Long id;
    private String title;

    private String author;

    private String publisher;

    private String edition;

    private Integer releaseYear;

    private BigDecimal price;

    private Integer quantity;

}
