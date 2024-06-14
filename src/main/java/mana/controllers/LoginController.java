package mana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mana.services.LoginService;

@Controller
@RequestMapping(value = "/home")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String getLogin(@RequestParam(required = false) String name, @RequestParam(required = false) String password, ModelMap modelMap) {
        modelMap.addAttribute("login", loginService.loginList(name, password));
        return "home";
    }

    @PostMapping(value = "/login")
    public String postLogin(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        String role = loginService.checkLogin(name, password);
        if (role != null) {
            if (role.equals("admin")) {
                modelMap.addAttribute("admin", loginService.loginList(name, password));
                return "admin";
            } else if (role.equals("user")) {
                modelMap.addAttribute("user", loginService.loginList(name, password));
                return "user";
            }
        }
        return "home";
    }
}