package com.alexotoodev.firstapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoContoller {

    private TodoService todoService;

    public TodoContoller(TodoService todoService) {
        super();
        this.todoService = todoService;
    }


    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username =getLoggedInUsername(model);
        List<Todo> todos = todoService.findTodoByUsername(username);
        model.addAttribute("todos", todos);

        return "listTodos";
    }


    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username, "",LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
       

        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String showTodoListPage( ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){

            return "todo";

        }

        String username =getLoggedInUsername(model);
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
       

       return "redirect:list-todos";
    }

     @RequestMapping("delete-todo")
    public String showdeleteTodoPage(@RequestParam int id){

        todoService.deleteTodoById(id);
       

       return "redirect:list-todos";
    }

     @RequestMapping(value="update-todo", method= RequestMethod.GET)
    public String showupdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoService.updateTodoById(id);
        model.addAttribute("todo", todo);

       return "todo";
    }

      @RequestMapping(value="update-todo", method= RequestMethod.POST)
    public String updateTodo( ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){

            return "todo";

        }

        String username =getLoggedInUsername(model);
        todo.setUsername(username);
        todoService.updateTodo(todo);
       

       return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    
    } 

   
}
