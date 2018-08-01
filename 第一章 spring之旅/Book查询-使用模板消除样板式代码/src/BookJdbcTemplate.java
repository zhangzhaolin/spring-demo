import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shiwa
 */
@Repository
public class BookJdbcTemplate {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book getBookById(Long id){
        String sql = "SELECT * FROM BOOK WHERE ID = ?";
        Book book = new Book();
        RowMapper<Book> mapper = (rs , rowNum) -> {
            book.setAuthor(rs.getString("author"));
            book.setDescription(rs.getString("description"));
            book.setId(rs.getLong("id"));
            book.setIsbn(rs.getString("isbn"));
            book.setTitle(rs.getString("title"));
            return book;
        };
        return jdbcTemplate.queryForObject(sql , mapper , id);
    }

}
