package com.example.tarefasNoSql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Document(collection = "tarefas") // Define a coleção do MongoDB
public class TarefaNo {

    @Id
    private String id;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @NotNull
    private String status;

    private LocalDateTime dataCriacao;
}
