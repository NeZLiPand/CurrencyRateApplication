package ua.open.api.andry.inkin.currencyrate.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {
    // Перейменувати цей метод, далі змінити код в цьому методі імплементувавши запроси до БД відновідно бізнес логіці та структурі класу "MainCurrencyRate"
    private List<String> getBooks() {
        List<String> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
            System.out.println("Connected to PostgreSQL database!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books.books");
            while (resultSet.next()) {
                result.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return result;
    }
}
