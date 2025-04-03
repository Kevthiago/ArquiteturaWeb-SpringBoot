package com.example.tarefas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "tarefas") // Indica que é um documento do MongoDB
public class TarefaMongo {

    @Id
    private String id; // MongoDB usa String para IDs

    private String titulo;
    private String descricao;
    private String status;
    private LocalDateTime dataCriacao;
}
