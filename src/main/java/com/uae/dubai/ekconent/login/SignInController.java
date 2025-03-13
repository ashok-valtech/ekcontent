package com.uae.dubai.ekconent.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uae.dubai.ekconent.Service.AuthenticationService;

@Controller
@SessionAttributes("name") 
public class SignInController {

    private AuthenticationService authenticationService;
    public SignInController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String gotoWelcomepage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        System.out.println("name" + name);

        Boolean b = authenticationService.authenticationService(name, password);
        System.out.println("b"  +b);
        if (b) {
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "welcome";
        } else {
            modelMap.put("errorMessage", "Invalid Credentitals");
            return "signin";
        }
    }
}
