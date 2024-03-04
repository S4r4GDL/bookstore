package com.exemple.bookstore.controller;

import com.exemple.bookstore.dto.CostumerDTO;
import com.exemple.bookstore.model.Costumer;
import com.exemple.bookstore.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    private CostumerRepository repository;
    @GetMapping
    public ResponseEntity getAllCostumers()
    {
        var response = repository.findAll();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity registerCostumer(@RequestBody @Validated CostumerDTO data){
        Costumer newCostumer= new Costumer(data);
        repository.save(newCostumer);
        System.out.println(data.getName());
        return ResponseEntity.ok().build();
    }
}
