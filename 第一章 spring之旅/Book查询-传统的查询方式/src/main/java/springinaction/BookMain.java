package springinaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookMain {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        try (
                Connection connection =
                        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/graduate?serverTimezone=Asia/Shanghai", "root", "123456");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescription(resultSet.getString("description"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        books.forEach(System.out::println);
    }
}
