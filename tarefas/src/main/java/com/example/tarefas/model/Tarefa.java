package com.example.tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Entity // Para bancos relacionais
@Document(collection = "tarefas") // Para MongoDB
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para bancos relacionais
    private Long id;

    @org.springframework.data.annotation.Id // Para MongoDB
    private String mongoId; // ID exclusivo para MongoDB

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @NotNull
    private String status; // Ex.: "Em andamento", "Concluído"

    private LocalDateTime dataCriacao;
}