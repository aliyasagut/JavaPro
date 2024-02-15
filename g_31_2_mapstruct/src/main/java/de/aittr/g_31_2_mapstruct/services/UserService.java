package de.aittr.g_31_2_mapstruct.services;

import de.aittr.g_31_2_mapstruct.domain.User;
import de.aittr.g_31_2_mapstruct.domain.UserDto;
import de.aittr.g_31_2_mapstruct.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public UserDto getById(int id) {
        return null;
    }

    public UserDto save(UserDto dto) {
        return null;
    }

    public void deletById(int id) {
        repository.deleteById(id);
    }
}
