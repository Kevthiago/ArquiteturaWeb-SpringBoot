package com.example.tarefasNoSql.service;

import com.example.tarefasNoSql.model.TarefaNo;
import com.example.tarefasNoSql.respository.TarefaNoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaNoService {

    @Autowired
    private TarefaNoRepository TarefaNoRepository;

    public List<TarefaNo> listar() {
        return TarefaNoRepository.findAll();
    }

    public Optional<TarefaNo> findById(String id) {
        return TarefaNoRepository.findById(id);
    }

    public TarefaNo criar(@Valid TarefaNo tarefa) {
        tarefa.setDataCriacao(java.time.LocalDateTime.now());
        return TarefaNoRepository.save(tarefa);
    }

    public TarefaNo atualizar(String id, @Valid TarefaNo tarefaAtualizada) {
        Optional<TarefaNo> tarefaOptional = TarefaNoRepository.findById(id);
        if (tarefaOptional.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada!");
        }
        TarefaNo tarefa = tarefaOptional.get();
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setStatus(tarefaAtualizada.getStatus());
        return TarefaNoRepository.save(tarefa);
    }

    public void excluir(String id) {
        TarefaNoRepository.deleteById(id);
    }
}
