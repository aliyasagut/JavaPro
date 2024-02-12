package de.aittr.g_31_2_security.controllers;

import de.aittr.g_31_2_security.domain.User;
import de.aittr.g_31_2_security.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PutMapping ("/set_admin/{username}")
    public void setRoleAdmin(@PathVariable String username) {
        service.setRoleAdmin(username);
    }
}