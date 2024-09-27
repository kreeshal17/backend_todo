package com.ToDo.projeectforgit.service;

import com.ToDo.projeectforgit.model.ToDo;
import com.ToDo.projeectforgit.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;
    //forgetting
      public List<ToDo> getAllToDos()
      {
         return  toDoRepository.findAll();
      }
      public ToDo saveToDo(ToDo todo)
      {
          return toDoRepository.save(todo);
      }
        public void    deleteToDoById(long id)
        {
            toDoRepository.deleteById(id);
       ;
        }
        public ToDo updateToDoStatus( boolean completed,long id)
        {
         ToDo toDo=toDoRepository.findById(id).orElseThrow();
         toDo.setCompleted(completed);
         return toDoRepository.save(toDo);
        }
}
