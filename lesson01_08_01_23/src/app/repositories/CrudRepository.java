package app.repositories;

// CRUD - Create Read Update Delete
// это необходимый минимум операций для работы в бд

import java.util.List;

public interface CrudRepository<T> {

    void save(T entity);

    T findById(int id);

    List<T> findAll();

    void update(T entity);

    void deleteById(int id);
}
