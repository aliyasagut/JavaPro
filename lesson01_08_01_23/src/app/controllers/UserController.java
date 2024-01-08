package app.controllers;

import app.domain.User;
import app.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserController {

    private Scanner scanner;
    private UserService service;

    public UserController(Scanner scanner, UserService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void addUser() {

        System.out.println("Введите email");
        String email = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        service.addUser(email, password);
    }

    public void findUserByEmail() {
        System.out.println("Введите email");
        String a = scanner.nextLine();

        System.out.println(service.getUserByEmail(a));
    }

    public void findAllUsers() {
        for (User user : service.getAllUsers()){
            System.out.println(user);
        }
    }

    // TODO реализовать метод получения одного пользователя из бд
    // TODO идентификатор нужно запросить у клиента через консоль
    // TODO реализовать метод получения всех пользователей
    // TODO оба эти метода должны просто выводить результат в консоль
}
