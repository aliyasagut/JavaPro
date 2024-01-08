package app.services;

import app.domain.User;
import app.repositories.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(String email, String password) {

        // TODO проверка параметров на Null и пустоту
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            throw new NullPointerException("Email or Password cannot be empty");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }

        // TODO проверить, не существует ли уже в бд пользователь с таким же email
        if (repository.findByEmail(email) != null) {
            throw new IllegalArgumentException("User with such email is already exist");
        }

        repository.save(new User(email, password));
    }

    // TODO реализовать методы по получению одного или всех пользователей

    public User getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

}
