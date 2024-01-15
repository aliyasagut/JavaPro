package de.aittr.g_31_2_rest.controllers;

import de.aittr.g_31_2_rest.domain.Cat;
import de.aittr.g_31_2_rest.services.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    // http://google.com
    // http://12.34.56.78:8080/cats - получить список всех котов
    // http://12.34.56.78:8080/dogs - получить список всех собак
    // http://12.34.56.78:8080/cats/5 - получить кота с id = 5
    // http://12.34.56.78:8080/cats/delete/3 - удалить кота с id = 3
    // http://12.34.56.78:8080/cows - не существующий эндпоинт -> 404


    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    //    @GetMapping("/test")  // метод принимает get запросы на эндпоинт /cats/test
    @GetMapping
    //метод принимает get запросы на эндпоинт /cats
    public List<Cat> getAll() {
        return service.getAll();
    }

    // 1 способ получения кода по ид - это передача ИД как подстроки запроса
    // http://12.34.56.78:8080/cats/5
//    @GetMapping("/{id}")
//    public Cat getById(@PathVariable int id) {
//        return service.getById(id);
//    }

    // 2 способ - это передача ид как параметра запроса
    // http://12.34.56.78:8080/cats/get?id=3$color=Gray
    @GetMapping("get")
    public Cat getById(@RequestParam int id){
        return service.getById(id);
    }
}
