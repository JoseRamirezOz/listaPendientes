package com.todoList.tareas.repo;

import com.todoList.tareas.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TareaRepository extends MongoRepository<Tarea,String> {

}
