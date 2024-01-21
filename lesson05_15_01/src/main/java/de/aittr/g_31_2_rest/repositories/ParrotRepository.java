package de.aittr.g_31_2_rest.repositories;

import de.aittr.g_31_2_rest.domain.Parrot;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ParrotRepository implements CrudRepository<Parrot> {

    private final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private final String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
    private final String DB_NAME = "31_2_parrots";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORT = "Himbeeren-123";

    private final String ID = "id";
    private final String WEIGHT = "weight";
    private final String COLOR = "color";

    // метод, который подключается к базе данных и возвращает объект подключения
    private Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);
            // url: jdbc:mysql://localhost:3306/31_2_parrots?user=root&password=Himbeeren-123
            String dbUrl = String.format("%s%s?user=%s&password=%s", DB_ADDRESS, DB_NAME, DB_USERNAME, DB_PASSWORT);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Parrot> getAll() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM parrot;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Parrot> parrots = new ArrayList<>();

            while (resultSet.next()) {
//                int id = resultSet.getInt(1); вариант 1: передать номер колонки
                int id = resultSet.getInt(ID); // вариант 2: передать название колонки
                String color = resultSet.getString(COLOR);
                double weight = resultSet.getDouble(WEIGHT);
                Parrot parrot = new Parrot(id, color, weight);
                parrots.add(parrot);
            }
            return parrots;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Parrot getById(int id) {
        try (Connection connection = getConnection()) {
            String query = String.format("SELECT * FROM parrot WHERE id = %d;", id);
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            Parrot parrot = null;

            while (resultSet.next()) {
                String color = resultSet.getString(COLOR);
                double weight = resultSet.getDouble(WEIGHT);
                parrot = new Parrot(id, color, weight);
            }

            return parrot;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Parrot parrot) {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM parrot WHERE id = %d;", id);
            connection.createStatement().executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Parrot save(Parrot parrot) {
        try (Connection connection = getConnection()) {
            String color = parrot.getColor();
            double weight = parrot.getWeight();
            String query = String.format("INSERT INTO parrot (color, weight) VALUES ('%s', %.2f);", color, weight);
            connection.createStatement().executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parrot;
    }
}
