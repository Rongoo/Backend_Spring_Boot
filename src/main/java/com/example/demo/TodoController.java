package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService ;

    @GetMapping("/todos/{name}")
    public List<TodoBean> getTodos(@PathVariable String name){
        return todoService.findTodosByUser(name);
    }

    @GetMapping("/todos/{name}/{id}")
    public TodoBean getTodos(@PathVariable String name, @PathVariable int id){
        return todoService.getTodoByID(name,id);
    }

    @DeleteMapping("/todos/{name}/{id}")
    public boolean delete(@PathVariable String name, @PathVariable int id){
        return todoService.removeTodo(new TodoBean(id));
    }

    @PutMapping("/todos/{name}")
    public boolean save(@PathVariable String name,@RequestBody TodoBean todo){
        todoService.updateTodo(todo);
        return true;
    }
}
