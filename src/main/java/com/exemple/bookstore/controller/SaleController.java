package com.exemple.bookstore.controller;

import com.exemple.bookstore.dto.SaleDTO;
import com.exemple.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {

        @Autowired
        private BookRepository repository;
        @GetMapping
        public ResponseEntity getAllSales()
        {
            var response = repository.findAll();
            return ResponseEntity.ok(response);
        }

        @PostMapping
        public ResponseEntity registerSale(@RequestBody @Validated SaleDTO data){
            System.out.println(data);
            return ResponseEntity.ok().build();
        }



}
