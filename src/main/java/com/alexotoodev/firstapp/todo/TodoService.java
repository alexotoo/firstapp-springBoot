package com.alexotoodev.firstapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;


@Service
public class TodoService {
private static  List<Todo> todos = new ArrayList<Todo>();

private static int todoIdCounter = 0;
static{
    todos.add(new Todo(++todoIdCounter, "tester", "learn spring boot", LocalDate.now().plusYears(1), false));

    todos.add(new Todo(++todoIdCounter, "tester", "aws", LocalDate.now().plusYears(1), false));

    todos.add(new Todo(++todoIdCounter, "tester", "apply for jobs", LocalDate.now().plusYears(3), false));
}

public List<Todo> findTodoByUsername(String username){
    Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);

    return todos.stream().filter(predicate).toList();

}

public void addTodo(String username, String description, LocalDate targetDate, boolean done){
    Todo todo = new Todo(++todoIdCounter, username, description, targetDate, done);
    todos.add(todo);

}

public void deleteTodoById(int id){
    Predicate<? super Todo> predicate = todo -> todo.getId() == id;
    todos.removeIf(predicate);

}
public Todo updateTodoById(int id){
    Predicate<? super Todo> predicate = todo -> todo.getId() == id;
    Todo todo = todos.stream().filter(predicate).findFirst().get();

    return todo;

}

 public void updateTodo(@Valid Todo todo){
        deleteTodoById(todo.getId());
        todos.add(todo);
    }

}
