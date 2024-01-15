package de.aittr.g_31_2_rest.controllers;

import de.aittr.g_31_2_rest.domain.Dog;
import de.aittr.g_31_2_rest.services.DogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private DogService service;

    public DogController(DogService service) {
        this.service = service;
    }

    // https:localhost:8080/dogs
    @GetMapping
    public List<Dog> getAll(){
        return service.getAll();
    }

    // https:localhost:8080/dogs/3
    @GetMapping("/{id}")
    public Dog getById(@PathVariable int id){
        return service.getById(id);
    }
}
