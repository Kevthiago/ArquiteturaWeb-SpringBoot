package com.example.tarefasNoSql.controller;

import com.example.tarefasNoSql.model.TarefaNo;
import com.example.tarefasNoSql.service.TarefaNoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaNoController {

    @Autowired
    private TarefaNoService tarefaNoService;

    @GetMapping
    public List<TarefaNo> listar() {
        return tarefaNoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaNo> getById(@PathVariable String id) {
        return tarefaNoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaNo criar(@Valid @RequestBody TarefaNo tarefa) {
        return tarefaNoService.criar(tarefa);
    }

    @PutMapping("/{id}")
    public TarefaNo atualizar(@PathVariable String id, @Valid @RequestBody TarefaNo tarefa) {
        return tarefaNoService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable String id) {
        tarefaNoService.excluir(id);
    }
}
