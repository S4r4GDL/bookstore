package com.exemple.bookstore.model;

import com.exemple.bookstore.dto.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="costumer")
@Entity
@EqualsAndHashCode(of="id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="name", length = 250, nullable = false)
    private String name;

    public Customer(CustomerDTO costumerDTO){
        this.name = costumerDTO.getName();
    }

}
