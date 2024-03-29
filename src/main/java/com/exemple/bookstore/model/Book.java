package com.exemple.bookstore.model;

import com.exemple.bookstore.dto.BookDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="book")
@Entity
@EqualsAndHashCode(of="id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="title", length = 250, nullable = false)
    private String title;

    @Column(name="author",  length = 150, nullable = false)
    private String author;

    @Column(name="publisher", length = 150, nullable = true)
    private String publisher;

    @Column(name="edition", length = 250, nullable = false)
    private String edition;

    @Column(name="release_year", nullable = false)
    private Integer releaseYear;

    @Column(name="price", nullable = false, precision = 17)
    private BigDecimal price;

    @Column(name="quantity", nullable = false)
    private Integer quantity;

    @Column(name="active", nullable = false)
    private Boolean active;

    public Book(BookDTO bookDTO){
        this.title = bookDTO.getTitle();
        this.author = bookDTO.getAuthor();
        this.publisher = bookDTO.getPublisher();
        this.edition = bookDTO.getEdition();
        this.releaseYear = bookDTO.getReleaseYear();
        this.price = bookDTO.getPrice();
        this.quantity = bookDTO.getQuantity();
        this.active = bookDTO.getActive();

    }

}
