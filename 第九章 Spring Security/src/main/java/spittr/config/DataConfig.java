package spittr.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@PropertySource(value = "classpath:/application.properties")
public class DataConfig {

    private final Environment environment;

    @Autowired
    public DataConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType(environment.getProperty("datasource.dbtype"));
        dataSource.setUrl(environment.getProperty("datasource.url"));
        dataSource.setUsername(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        // 配置WallFilter
        dataSource.setFilters("wall");
        // PsCache
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource){
        return new JdbcTemplate( dataSource);
    }

}
