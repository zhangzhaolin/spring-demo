
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertNotNull;


/**
 * @author shiwa
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-config.xml")
@ActiveProfiles("dev")
public class UserDaoTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void text() throws Exception {
        assertNotNull(dataSource);
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        List<String> results = jdbc.query("SELECT * FROM dev" ,
                (resultSet , i) -> {
                    return resultSet.getLong("id") + " : " + resultSet.getString("name");
                });

        for (String r : results) {
            System.out.println(r);
        }
    }

    @After
    public void shutdown() {

    }

}
