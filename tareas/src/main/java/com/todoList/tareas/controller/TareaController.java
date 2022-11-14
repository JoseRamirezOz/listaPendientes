package com.todoList.tareas.controller;

import com.todoList.tareas.model.Tarea;
import com.todoList.tareas.repo.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    // TRAER LOS DATOS
    @GetMapping("")
    List<Tarea> index(){
        return tareaRepository.findAll();
    }

    // ENVIAR LOS DATOS
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")

    Tarea create(@RequestBody  Tarea tarea){
        return tareaRepository.save(tarea);
    }

    //ACTUALIZAR LOS DATOS
    @PutMapping("{id}")
    Tarea update(@PathVariable  String id, @RequestBody Tarea tarea){
        Tarea tareaFromDb = tareaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        tareaFromDb.setNombre(tarea.getNombre());
        tareaFromDb.setCompletado(tarea.isCompletado());

        return tareaRepository.save(tareaFromDb);
    }

    // ELIMINAR LOS DATOS
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Tarea tarea = tareaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        tareaRepository.delete(tarea);
    }


}
