package com.example.democrud.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@EntityScan("com.example.democrud.model")

@AllArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
