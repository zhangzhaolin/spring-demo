import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shiwa
 */
public class BookJdbcTemplate {

    public Book getBookById(JdbcTemplate jdbcTemplate,Long id){

        String sql = "select * FROM book where id = ?";

        RowMapper<Book> rowMapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescription(resultSet.getString("description"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setReader(resultSet.getString("reader"));
                book.setTitle(resultSet.getString("title"));
                return book;
            }
        };

        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

}
