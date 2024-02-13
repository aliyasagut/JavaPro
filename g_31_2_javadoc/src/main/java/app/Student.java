package app;

/**
 * Класс, описывающий студента
 * Для работы с объектами студентов предусмотрен {@link StudentService}
 *
 * @author      Mega Coder
 * @version     2.0.0
 */
public class Student {

    /**
     * Идентификатор студента
     */
    private int id;

    /**
     * Имя студента
     */
    private String name;

    /**
     * Средний бал стдента
     */
    private double averageRate;

    /**
     * Конструктор для создания студентов
     *
     * @param   id    идентификатор студента
     * @param   name  имя студента
     * @see     Student#Student(int, String, double)
     * @since   2.0.0
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Конструктор для создания студнета
     *
     * @param id            идентификатор
     * @param name          имя
     * @param averageRate   средний бал
     * @see                 Student#Student(int, String)
     * @since               1.0.0
     * @deprecated          при поступлении у студента еще нет среднего балла
     */
    public Student(int id, String name, double averageRate) {
        this.id = id;
        this.name = name;
        this.averageRate = averageRate;
    }

    /**
     * Геттер
     *
     * @return  Id студента
     * @see     Student#id
     */
    public int getId() {
        return id;
    }

    /**
     * Мптод для преобразования объекта студента в его строковое представление
     *
     * @return объект студента в виде строки
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", averageRate=" + averageRate +
                '}';
    }
}
