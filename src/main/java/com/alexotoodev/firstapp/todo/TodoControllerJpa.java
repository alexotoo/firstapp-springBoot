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
public class TodoControllerJpa  {

    public TodoControllerJpa(TodoService todoService, TodoRespository todoRespository) {
        super();
       
        this.todoRespository=todoRespository;
    }

   
    private TodoRespository todoRespository;


    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username =getLoggedInUsername(model);




        List<Todo> todos = todoRespository.findByUsername(username);
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
        todo.setUsername(username);
        todoRespository.save(todo);
   
       

       return "redirect:list-todos";
    }

     @RequestMapping("delete-todo")
    public String showdeleteTodoPage(@RequestParam int id){

        todoRespository.deleteById(id);
       

       return "redirect:list-todos";
    }

     @RequestMapping(value="update-todo", method= RequestMethod.GET)
    public String showupdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoRespository.findById(id).get();
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
        todoRespository.save(todo);
      
       

       return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    
    } 

   
}

