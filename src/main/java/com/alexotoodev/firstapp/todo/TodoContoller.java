package com.alexotoodev.firstapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoContoller {


    @RequestMapping("list-todos")
    public String listAllTodos(){
        return "listTodos";
    }

    
}
