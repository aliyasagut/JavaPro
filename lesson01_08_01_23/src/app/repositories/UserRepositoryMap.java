package app.repositories;

import app.domain.User;

import java.util.*;

public class UserRepositoryMap implements UserRepository {

    private Map<Integer, User> users = new HashMap<>();
    private int currentId;

    @Override
    public void save(User entity) {
        entity.setId(++currentId);
        users.put(currentId, entity);
    }

    @Override
    public User findById(int id) {
        // TODO реализовать метод

        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        // TODO реализовать метод

        List<User> allUsers = new ArrayList<>(users.values());
        return allUsers;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User findByEmail(String email) {

        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
