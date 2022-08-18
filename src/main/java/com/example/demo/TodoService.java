package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    static List<TodoBean> todos = new ArrayList<TodoBean>();
    private static int counter=0;
    static {
        todos.add(new TodoBean(++counter,"123","Java lernen",new Date(),true));
        todos.add(new TodoBean(++counter,"123","Angular lernen",new Date(),false));
        todos.add(new TodoBean(++counter,"123","Spring boot lernen",new Date(),false));
        todos.add(new TodoBean(++counter,"123","Spring boot lernen",new Date(),false));
    }

    public static List<TodoBean> getTodos() {
        return todos;
    }
    public static List<TodoBean> findTodosByUser(String username) {
        return todos.stream().filter(todoBean -> todoBean.username.equals(username)).collect(Collectors.toList());
    }

    public TodoBean getTodoByID(String username, int id){
        return findTodosByUser(username).stream().filter(todoBean -> todoBean.getId()==id).collect(Collectors.toList()).get(0);

    }

    public void updateTodo(TodoBean todo){
        if(todo.getId()==-1){
            todo.setId(++counter);
        }else{
            todos.remove(todo);
        }
        todos.add(todo);
    }

    public boolean removeTodo(TodoBean todo){
        return todos.remove(todo);
    }
}
