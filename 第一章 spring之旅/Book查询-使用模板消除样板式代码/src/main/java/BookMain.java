import dao.BookJdbcTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Book;

/**
 * @author shiwa
 */
public class BookMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        BookJdbcTemplate bookJdbcTemplate = (BookJdbcTemplate) context.getBean("bookJdbcTemplate");
        try {
            Book book = bookJdbcTemplate.getBookById(1L);
            System.out.println(book);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("未找到或找到多条数据.");
        }
    }
}
