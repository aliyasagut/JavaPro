package de.aittr.g_31_2_mapstruct.controllers;

import de.aittr.g_31_2_mapstruct.domain.User;
import de.aittr.g_31_2_mapstruct.domain.UserDto;
import de.aittr.g_31_2_mapstruct.services.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto dto){
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.deletById(id);
    }
}
