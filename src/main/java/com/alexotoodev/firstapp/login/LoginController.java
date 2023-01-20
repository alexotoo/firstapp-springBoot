package com.alexotoodev.firstapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


// @Controller
// public class LoginController {

    
//     @RequestMapping("login")
//     public String toLoginPage(@RequestParam String name, ModelMap model){
//         model.put("name", name);
//         System.out.println(name);
     


//         return "login";
 
//     }
// }
@Controller
@SessionAttributes("name")
public class LoginController {
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService  ){ super();
        this.authenticationService = authenticationService;

    }

    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLoginPage(){

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String toWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){

        if (authenticationService.authenticate(name, password)) {

            model.put("name",name);
            model.put("password",password);
    
            return "welcome";
            
        }

        model.put("erroMessage", "invalid Credentials! please try again");
        return "login";
    }

 
}
