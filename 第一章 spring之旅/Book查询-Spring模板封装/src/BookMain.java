import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author shiwa
 */
public class BookMain {

    public static void main(String []args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate =  context.getBean(JdbcTemplate.class);
        BookJdbcTemplate template = new BookJdbcTemplate();

        try {
            Book book = template.getBookById(jdbcTemplate,1L);
            System.out.println(book);
        }catch (EmptyResultDataAccessException ex){
            System.out.println("未找到或找到多条数据.");
        }

    }
}
