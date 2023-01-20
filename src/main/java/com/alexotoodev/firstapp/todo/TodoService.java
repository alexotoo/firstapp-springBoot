package com.alexotoodev.firstapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


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
    return todos;

}

public void addTodo(String username, String description, LocalDate targetDate, boolean done){
    Todo todo = new Todo(++todoIdCounter, username, description, targetDate, done);
    todos.add(todo);

}

}
