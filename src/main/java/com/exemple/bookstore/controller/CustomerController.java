package com.exemple.bookstore.controller;

import com.exemple.bookstore.dto.CustomerDTO;
import com.exemple.bookstore.model.Customer;
import com.exemple.bookstore.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costumer")
public class CustomerController {

    @Autowired
    private CostumerRepository repository;
    @GetMapping
    public ResponseEntity getAllCostumers()
    {
        var response = repository.findAll();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity registerCostumer(@RequestBody @Validated CustomerDTO data){
        Customer newCostumer= new Customer(data);
        repository.save(newCostumer);
        System.out.println(data.getName());
        return ResponseEntity.ok().build();
    }
}
