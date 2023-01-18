package com.alexotoodev.firstapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello to first app";
 
    }



    @RequestMapping("say-html")
    @ResponseBody
    public String makeHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>spring app</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Spring App</h1>");
        sb.append("</body>");
        sb.append("</html>");


        return sb.toString();
 
    }
    
    @RequestMapping("say-jsp")
    public String sayHelloJsp(){
     


        return "sayHello";
 
    }





    
}
