package com.ToDo.projeectforgit.controller;


import com.ToDo.projeectforgit.model.ToDo;
import com.ToDo.projeectforgit.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
   @Autowired
    ToDoService toDoService;
@GetMapping
    public List<ToDo> getAllToDos()
    {
        return toDoService.getAllToDos();
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable long id)
    {
         toDoService.deleteToDoById(id);
    }
    @PostMapping
    public ToDo  saveToDo(@RequestBody ToDo todo)
    {
        return toDoService.saveToDo(todo);
    }
    @PutMapping("/{id}")
    public  ToDo updateToDOStatus(@RequestBody long id,@RequestParam boolean completed)
    {
        return toDoService.updateToDoStatus(completed, id);
    }
}
