package app;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addtudent (Student student) {
        students.add(student);
    }

    public Student getById(int id) {
        Student student = students
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            throw new NoSuchElementException("Не существующий идентификатор");
        }

        return student;
    }
}
