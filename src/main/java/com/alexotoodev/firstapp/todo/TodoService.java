package com.alexotoodev.firstapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
private static  List<Todo> todos = new ArrayList<Todo>();
static{
    todos.add(new Todo(1, "tester", "learn spring boot", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(2, "tester", "aws", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(3, "tester", "apply for jobs", LocalDate.now().plusYears(3), false));
    todos.add(new Todo(4, "tester", "become snr. developer", LocalDate.now().plusYears(2), false));
    todos.add(new Todo(5, "tester", "travel to Ghana", LocalDate.now().plusYears(1), false));
}



public List<Todo> findTodoByUsername(String username){
    return todos;

}






}
