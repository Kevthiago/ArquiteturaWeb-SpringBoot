package com.example.tarefas.repository;

import com.example.tarefas.model.TarefaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaMongoRepository extends MongoRepository<TarefaMongo, String> {}
