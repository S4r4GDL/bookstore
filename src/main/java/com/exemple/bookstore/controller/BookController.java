package com.exemple.bookstore.controller;

import com.exemple.bookstore.dto.BookDTO;
import com.exemple.bookstore.model.Book;
import com.exemple.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;
    @GetMapping
    public ResponseEntity getAllBooks()
    {
        var response = repository.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity registerBook(@RequestBody @Validated BookDTO data){
        Book newBook = new Book(data);
        repository.save(newBook);
        System.out.println(data.getAuthor());
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody @Validated BookDTO data){
        Book book = repository.getReferenceById(data.getId());
        book.setAuthor(data.getAuthor());
        book.setTitle(data.getTitle());
        book.setPublisher(data.getPublisher());
        book.setEdition(data.getEdition());
        book.setReleaseYear(data.getReleaseYear());
        book.setPrice(data.getPrice());
        book.setQuantity(data.getQuantity());

        return ResponseEntity.ok(book.toString());
    }

}
