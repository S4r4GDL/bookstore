package com.exemple.bookstore.controller;

import com.exemple.bookstore.dto.BookDTO;
import com.exemple.bookstore.model.Book;
import com.exemple.bookstore.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable Long id)
    {
        var response = repository.findById(id);
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
    @Transactional
    public ResponseEntity updateBook(@RequestBody @Validated BookDTO data){
        Optional<Book> optionalBook = repository.findById(data.getId());
        if(optionalBook.isPresent())
        {
            Book book = optionalBook.get();
            book.setAuthor(data.getAuthor());
            book.setTitle(data.getTitle());
            book.setPublisher(data.getPublisher());
            book.setEdition(data.getEdition());
            book.setReleaseYear(data.getReleaseYear());
            book.setPrice(data.getPrice());
            book.setQuantity(data.getQuantity());
            book.setActive(data.getActive());
            return ResponseEntity.ok(book.toString());
        }
        else
            return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}/active")
    public ResponseEntity deleteBook(@PathVariable Long id, @PathVariable Boolean active){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
