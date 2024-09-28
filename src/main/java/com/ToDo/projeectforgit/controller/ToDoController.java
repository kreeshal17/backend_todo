package com.ToDo.projeectforgit.controller;


import com.ToDo.projeectforgit.model.ToDo;
import com.ToDo.projeectforgit.service.ToDoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@Configuration
//@EnableWebSecurity
@RequestMapping("/api/todos")
public class ToDoController {
   @Autowired
    ToDoService toDoService;
@GetMapping
    public List<ToDo> getAllToDos()
    {
        return toDoService.getAllToDos();
    }
//    @GetMapping("x")
//    public CsrfToken gettoken(HttpServletRequest request)
//    {
//        return (CsrfToken) request.getAttribute();
//    }

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
