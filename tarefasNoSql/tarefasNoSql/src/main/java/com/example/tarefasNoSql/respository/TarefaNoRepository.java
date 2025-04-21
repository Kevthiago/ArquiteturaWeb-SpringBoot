package com.example.tarefasNoSql.respository;

import com.example.tarefasNoSql.model.TarefaNo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaNoRepository extends MongoRepository<TarefaNo, String> {}