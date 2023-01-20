package com.alexotoodev.firstapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
        List<Todo> todos = todoService.findTodoByUsername("tester");
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showAddTodoPage(){
       

        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String showTodoListPage(){
       

       return "redirect:list-todos";
    }

    
}
