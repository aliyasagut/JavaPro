package de.aittr.g_31_2_rest.repositories;

import de.aittr.g_31_2_rest.domain.Cat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CatRepository implements CrudRepository<Cat>{

    private Map<Integer, Cat> cats = new HashMap<>();
    private int currentId;

    public CatRepository(){
        save(new Cat("Black", 2.34));
        save(new Cat("Wight", 1.89));
        save(new Cat("Grey", 4.14));
    }

    @Override
    public Cat save(Cat cat) {
        cat.setId(++currentId);
        cats.put(currentId, cat);
        return cat;
    }

    @Override
    public List<Cat> getAll() {
        return new ArrayList<>(cats.values());
    }

    @Override
    public Cat getById(int id) {
        return cats.get(id);
    }

    @Override
    public void update(Cat cat) {

    }

    @Override
    public void deleteById(int id) {

    }
}
