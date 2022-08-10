package br.com.senac.todo.controllers;

import br.com.senac.todo.model.ToDo;
import br.com.senac.todo.services.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    ResponseEntity<List<ToDo>> getAllTodos() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    ResponseEntity<ToDo> getToDo(@PathVariable long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/todo")
    ResponseEntity<ToDo> create(@RequestBody ToDo toDo) {
        return new ResponseEntity<>(service.save(toDo), HttpStatus.CREATED);
    }

    @PostMapping("/todos")
    ResponseEntity<List<ToDo>> create(@RequestBody List<ToDo> toDos) {
        return new ResponseEntity<>(service.saveAll(toDos), HttpStatus.CREATED);
    }

    @PutMapping("/todo")
    ResponseEntity<ToDo> update(@RequestBody ToDo toDo) {
        return new ResponseEntity<>(service.save(toDo), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/todos")
    ResponseEntity<List<ToDo>> update(@RequestBody List<ToDo> toDos) {
        return new ResponseEntity<>(service.saveAll(toDos), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("todo/{id}")
    ResponseEntity delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}