package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pojo.Book;

/**
 * @author shiwa
 */
@Component
public class BookJdbcTemplate {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setAuthor(rs.getString("author"));
        book.setDescription(rs.getString("description"));
        book.setId(rs.getLong("id"));
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        return book;
    };

    @Autowired
    public BookJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book getBookById(Long id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, bookRowMapper, id);
    }

}
